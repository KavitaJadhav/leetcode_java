package patterns.stream_processing.aggregation;
import java.util.*;

//### Next — Streaming Temperature Statistics
//
//**Question:**
//Given a stream of `(timestamp, temperature)` events, design a data structure that returns the **minimum, maximum, and average temperature over the previous `W` minutes** for a given timestamp. Events initially arrive in timestamp order.
//
//**Pattern:** Sliding Window + Queue + Running Sum + Min/Max structures
//
//**Complexity target:**
//
//* `add()` → **O(1) amortized**
//* `getStats()` → **O(1)**
//* Space → **O(W)**
//
//**Follow-up:** What changes if temperature events can arrive **out of order**?


public class TemperatureStatistics {

    private final int window;
    private final ArrayDeque<int[]> events;
    private final Deque<int[]> minDeque;
    private final Deque<int[]> maxDeque;
    private long runningSum;

    public TemperatureStatistics(int windowInSeconds) {
        this.window = windowInSeconds;
        this.events = new ArrayDeque<>();
        this.minDeque = new ArrayDeque<>();
        this.maxDeque = new ArrayDeque<>();
        this.runningSum = 0;
    }

    public void add(int timestamp, int temperature) {
        events.offer(new int[]{timestamp, temperature});
        runningSum += temperature;

        // Maintain increasing temperatures for minimum
        while (!minDeque.isEmpty()
                && minDeque.peekLast()[1] >= temperature) {
            minDeque.pollLast();
        }
        minDeque.offerLast(new int[]{timestamp, temperature});

        // Maintain decreasing temperatures for maximum
        while (!maxDeque.isEmpty()
                && maxDeque.peekLast()[1] <= temperature) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(new int[]{timestamp, temperature});

        removeExpired(timestamp);
    }

    private void removeExpired(int currentTimestamp) {
        int startTime = currentTimestamp - window;

        while (!events.isEmpty()
                && events.peekFirst()[0] < startTime) {

            int[] expiredEvent = events.pollFirst();
            int expiredTimestamp = expiredEvent[0];
            int expiredTemperature = expiredEvent[1];

            runningSum -= expiredTemperature;

            if (!minDeque.isEmpty()
                    && minDeque.peekFirst()[0] == expiredTimestamp
                    && minDeque.peekFirst()[1] == expiredTemperature) {
                minDeque.pollFirst();
            }

            if (!maxDeque.isEmpty()
                    && maxDeque.peekFirst()[0] == expiredTimestamp
                    && maxDeque.peekFirst()[1] == expiredTemperature) {
                maxDeque.pollFirst();
            }
        }
    }

    public int getMin() {
        return minDeque.peekFirst()[1];
    }

    public int getMax() {
        return maxDeque.peekFirst()[1];
    }

    public double getAverage() {
        if (events.isEmpty()) {
            return 0.0;
        }

        return (double) runningSum / events.size();
    }
}