package mock_practice;

public class RollingStatistics {

    static class Event {
        int value;
        long timestamp;

        Event(int value, long timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final long windowSize;
    private Deque<Event> window = new LinkedList<>();

    private long sum = 0;
    private int count = 0;

    public RollingStatistics(long windowSize) {
        this.windowSize = windowSize;
    }

    public void addEvent(int value, long timestamp) {
        window.addLast(new Event(value, timestamp));
        sum += value;
        count++;

        evictOld(timestamp);
    }

    private void evictOld(long currentTime) {
        while (!window.isEmpty() &&
                currentTime - window.peekFirst().timestamp > windowSize) {

            Event old = window.pollFirst();
            sum -= old.value;
            count--;
        }
    }

    public double getAverage() {
        return count == 0 ? 0.0 : (double) sum / count;
    }

    public long getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }

    public class Main {
        public static void main(String[] args) {
            RollingStatistics stats = new RollingStatistics(10);

            stats.addEvent(10, 100);
            stats.addEvent(20, 101);
            stats.addEvent(30, 102);

            System.out.println(stats.getSum());     // 60
            System.out.println(stats.getAverage()); // 20.0

            stats.addEvent(40, 200); // old events evicted

            System.out.println(stats.getSum());
        }
    }
}