package patterns.stream_processing;

public class RateLimiterTokenBucket {
    private int capacity;
    private double tokens;
    private int refillRate;
    private long lastRefillTimeStamp;

    public RateLimiterTokenBucket(Integer capacity, Integer refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTimeStamp = System.currentTimeMillis();
    }

    public boolean allow() {
        refillTokens();
        if (tokens < 1)
            return false;
        tokens--;

        return true;
    }

    private void refillTokens() {
        long now = System.currentTimeMillis();
        long timeElspsed = (now - lastRefillTimeStamp) / 1000;
        tokens = Math.min(capacity, tokens + (timeElspsed * refillRate));
        this.lastRefillTimeStamp = now;
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiterTokenBucket rateLimiter = new RateLimiterTokenBucket(3, 1);
        System.out.println(rateLimiter.allow());
        Thread.sleep(3000);
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
        Thread.sleep(3000);
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
        System.out.println(rateLimiter.allow());
    }
}
