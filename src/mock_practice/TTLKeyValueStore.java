package mock_practice;

public class TTLKeyValueStore {
    static class ValueWithExpiry {
        String value;
        long expiryTime; // epoch millis

        ValueWithExpiry(String value, long ttlMillis) {
            this.value = value;
            this.expiryTime = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    private Map<String, ValueWithExpiry> store = new HashMap<>();

    public void put(String key, String value, long ttlMillis) {
        store.put(key, new ValueWithExpiry(value, ttlMillis));
    }

    public String get(String key) {
        ValueWithExpiry v = store.get(key);

        if (v == null) return null;

        if (v.isExpired()) {
            store.remove(key);
            return null;
        }

        return v.value;
    }

    public void delete(String key) {
        store.remove(key);
    }
}