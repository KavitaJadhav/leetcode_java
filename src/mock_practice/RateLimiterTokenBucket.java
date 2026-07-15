package mock_practice;

public class RateLimiterTokenBucket {

    private final int capacity;
    private final double refillRatePerSec;

    private double tokens;
    private long lastRefillTimestamp;

    public RateLimiterTokenBucket(int capacity, double refillRatePerSec) {
        this.capacity = capacity;
        this.refillRatePerSec = refillRatePerSec;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        double seconds = (now - lastRefillTimestamp) / 1000.0;

        tokens = Math.min(capacity, tokens + seconds * refillRatePerSec);
        lastRefillTimestamp = now;
    }
}