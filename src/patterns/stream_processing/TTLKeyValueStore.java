package patterns.stream_processing;

import java.util.HashMap;
import java.util.Map;

public class TTLKeyValueStore {
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

    public TTLKeyValueStore(Long validDuration) {
        keyValues = new HashMap<>();
        this.validDuration = validDuration;
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

    public static void main(String[] args) throws InterruptedException {
        TTLKeyValueStore ttlKeyValueStore = new TTLKeyValueStore(10000L);
        ttlKeyValueStore.put(1, "one");
        ttlKeyValueStore.put(2, "two");
        ttlKeyValueStore.put(3, "three");
        ttlKeyValueStore.put(4, "four");
        ttlKeyValueStore.put(5, "five", 2000L);
        System.out.println(ttlKeyValueStore.get(1));
        System.out.println(ttlKeyValueStore.get(5));
        Thread.sleep(3000);
        System.out.println(ttlKeyValueStore.get(5));
    }
}
