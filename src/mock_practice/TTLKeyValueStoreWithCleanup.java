package mock_practice;

import java.util.*;
import java.util.concurrent.*;

public class TTLKeyValueStoreWithCleanup {
    static class ValueWithExpiry {
        String value;
        long expiryTime;

        ValueWithExpiry(String value, long ttlMillis) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    private final Map<String, ValueWithExpiry> store = new ConcurrentHashMap<>();

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    public TTLKeyValueStoreWithCleanup() {
        startCleanupTask();
    }

    // Put with TTL
    public void put(String key, String value, long ttlMillis) {
        store.put(key, new ValueWithExpiry(value, ttlMillis));
    }

    // Get
    public String get(String key) {
        ValueWithExpiry v = store.get(key);

        if (v == null) return null;

        if (v.isExpired()) {
            store.remove(key);
            return null;
        }

        return v.value;
    }

    // Delete
    public void delete(String key) {
        store.remove(key);
    }

    // Background cleanup thread
    private void startCleanupTask() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                long now = System.currentTimeMillis();

                for (Map.Entry<String, ValueWithExpiry> entry : store.entrySet()) {
                    if (entry.getValue().expiryTime < now) {
                        store.remove(entry.getKey());
                    }
                }

            } catch (Exception e) {
                // log error in real system
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS); // run every 1 second
    }

    // Shutdown hook (important in real systems)
    public void shutdown() {
        scheduler.shutdown();
    }
}