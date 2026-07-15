package mock_practice;

public class RateLimiterSlidingWindow {
    private final int limit;
    private final long windowSizeInMillis;

    private Map<String, Queue<Long>> userRequests = new HashMap<>();

    public RateLimiterSlidingWindow(int limit, int windowSizeInSeconds) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInSeconds * 1000L;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        userRequests.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> queue = userRequests.get(userId);

        // Remove old requests outside window
        while (!queue.isEmpty() && now - queue.peek() > windowSizeInMillis) {
            queue.poll();
        }

        // Check limit
        if (queue.size() < limit) {
            queue.offer(now);
            return true;
        }

        return false;
    }
}

