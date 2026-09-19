package patterns.stream_processing.ranking;

//### Custom Variant — Top K Frequent Events by Timestamp
//
//Given timestamped events that may arrive **out of order**, support:
//
//* `add(timestamp, eventType)`
//* `topK(timestamp, K)` → return the **K most frequent event types with timestamp ≤ given timestamp**.
//
//**Complexity**
//
//* `add()` → **O(log M)**
//* `topK()` → **O(E + U log K)**
//* Space → **O(E + U)**
//
//`M` = distinct timestamps, `E` = events up to the query timestamp, `U` = distinct event types.
//

//Approach
//Add all the events in the Treemap - it will take care of ordering and handling out of order events
//retrieve events using headMap;
//create a frequency map - based on event type and count
//create a heap of size k and add events in heap
//create the final result

import java.util.*;

public class TopKFrequentEvents {

    TreeMap<Integer, ArrayList<String>> map;

    public TopKFrequentEvents() {
        map = new TreeMap<>();
    }

    public void add(int timeStamp, String eventType) {
        map.computeIfAbsent(timeStamp, key -> new ArrayList<>())
                .add(eventType);
    }

    public List<String> topK(int timestamp, int k) {

        // Count frequencies of events up to timestamp
        NavigableMap<Integer, ArrayList<String>> entries =
                map.headMap(timestamp, true);

        Map<String, Integer> frequency = new HashMap<>();

        for (ArrayList<String> events : entries.values()) {
            for (String event : events) {
                frequency.put(
                        event,
                        frequency.getOrDefault(event, 0) + 1
                );
            }
        }

        // Min heap containing only top K frequent events
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(
                        (entry1, entry2) ->
                                Integer.compare(
                                        entry1.getValue(),
                                        entry2.getValue()
                                )
                );

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract results
        List<String> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

        TopKFrequentEvents events = new TopKFrequentEvents();

        events.add(10, "login");
        events.add(5, "purchase");
        events.add(8, "login");
        events.add(10, "login");
        events.add(3, "purchase");
        events.add(7, "logout");

        System.out.println(events.topK(10, 2));

        // login -> 3
        // purchase -> 2
        // logout -> 1
        //
        // Output:
        // [login, purchase]
    }
}