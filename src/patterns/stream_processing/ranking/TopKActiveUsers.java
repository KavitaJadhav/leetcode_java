package patterns.stream_processing.ranking;

//### Top-K Active Users in Last 1 Hour
//
//Given a stream of `(timestamp, userId)` events, return the **K users with the most events in the previous 1 hour** at a given timestamp.
//
//**Example:**
//`(100,A), (200,B), (300,A), (400,A), ...`
//`topK(3600, 2)` → users with the highest event counts in `[0, 3600]`.
//
//**Pattern:** Sliding Window + HashMap + Min Heap
//
//**Complexity target**
//
//* `add()` → **O(1)** amortized
//* `topK()` → **O(U log K)**
//* Space → **O(E + U)**
//
//`E` = events in the window, `U` = distinct users.
//
//**Follow-up:** What changes if events can arrive **out of order**?
//

import java.util.*;

public class TopKActiveUsers {

    private static final int WINDOW = 3600;

    Queue<int[]> events;
    Map<Integer, Integer> userFrequency;

    public TopKActiveUsers() {
        events = new LinkedList<>();
        userFrequency = new HashMap<>();
    }

    public void add(int timestamp, int userId) {

        events.offer(new int[]{timestamp, userId});

        userFrequency.put(
                userId,
                userFrequency.getOrDefault(userId, 0) + 1
        );
    }

    public List<Integer> topK(int timestamp, int k) {

        // Remove events outside the last 1 hour
        int startTime = timestamp - WINDOW;

        while (!events.isEmpty()
                && events.peek()[0] < startTime) {

            int[] event = events.poll();
            int userId = event[1];

            int frequency = userFrequency.get(userId);

            if (frequency == 1) {
                userFrequency.remove(userId);
            } else {
                userFrequency.put(userId, frequency - 1);
            }
        }

        // Min heap by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(
                        (entry1, entry2) ->
                                Integer.compare(
                                        entry1.getValue(),
                                        entry2.getValue()
                                )
                );

        for (Map.Entry<Integer, Integer> entry
                : userFrequency.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

        TopKActiveUsers stream = new TopKActiveUsers();

        stream.add(100, 1);
        stream.add(200, 2);
        stream.add(300, 1);
        stream.add(400, 1);
        stream.add(500, 2);
        stream.add(600, 3);

        System.out.println(stream.topK(600, 2));

        // User 1 -> 3 events
        // User 2 -> 2 events
        // User 3 -> 1 event
        //
        // [1, 2]
    }
}