package patterns.stream_processing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TTLKeyValueStoreAutoExpire {
    class Node {
        public String getValue() {
            return value;
        }

        private String value;

        public void setValue(String value) {
            this.value = value;
        }

        public void setExpiry(long expiry) {
            this.expiry = expiry;
        }

        private long expiry;

        public Node() {
        }

        ;

        public Node(String value, Long expiry) {
            this.value = value;
            this.expiry = expiry;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expiry;
        }

    }

    Map<Integer, Node> keyValues;
    Long validDuration;
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public TTLKeyValueStoreAutoExpire(Long validDuration) {
        keyValues = new ConcurrentHashMap<>();
        this.validDuration = validDuration;
        startCleanup();
    }

    private void startCleanup() {
        executor.scheduleAtFixedRate(() -> {
            try {
                Iterator<Map.Entry<Integer, Node>> iterator = keyValues.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer, Node> entry = iterator.next();
                    if (entry.getValue().isExpired())
                        keyValues.remove(entry.getKey());
                }
            } catch (Exception exception) {
                System.out.println("Scheduler task to cleanup data failed");
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public void put(Integer key, String value, Long expiryTime) {
        Node node;
        node = keyValues.getOrDefault(key, new Node());
        node.setExpiry(System.currentTimeMillis() + expiryTime);
        node.setValue(value);
        keyValues.put(key, node);
    }

    public void put(Integer key, String value) {
        put(key, value, validDuration);
    }

    public String get(Integer key) {
        if (!keyValues.containsKey(key)) return null;
        Node node = keyValues.get(key);
        if (node.isExpired()) {
            keyValues.remove(key);
            return null;
        }
        return node.value;
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        TTLKeyValueStoreAutoExpire ttlKeyValueStore = new TTLKeyValueStoreAutoExpire(10000L);
        ttlKeyValueStore.put(1, "one");
        ttlKeyValueStore.put(2, "two");
        ttlKeyValueStore.put(3, "three");
        ttlKeyValueStore.put(4, "four");
        ttlKeyValueStore.put(5, "five", 2000L);
        System.out.println(ttlKeyValueStore.get(1));
        System.out.println(ttlKeyValueStore.get(5));
        Thread.sleep(3000);
        System.out.println(ttlKeyValueStore.get(5));
        ttlKeyValueStore.shutdown();
    }
}
