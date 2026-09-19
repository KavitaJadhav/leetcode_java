package patterns.stream_processing.aggregation;

//### Custom Variant 5 — Maximum Value in a Time Window
//
//Design a data structure that receives **timestamped events out of order** and supports:
//
//`add(timestamp, value)`
//`getMax(startTime, endTime)` → return the **maximum value among all events whose timestamp falls within `[startTime, endTime]`**.
//
//**Pattern:** `TreeMap` + range traversal / ordered aggregation
//
//**Complexity target**
//
//* `add()` → **O(log M)**
//* `getMax()` → **O(R)**, worst case **O(M)**
//* Space → **O(E)** if storing every event, or **O(M)** if only one maximum per timestamp is needed
//
//Try the approach first; ask for **code** when ready.

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class EventMax {

    TreeMap<Integer, Integer> map;

    public EventMax() {
        map = new TreeMap<>();
    }

    public void add(int timeStamp, int value) {
        map.put(
                timeStamp,
                Math.max(map.getOrDefault(timeStamp, Integer.MIN_VALUE), value)
        );
    }

    public int getMax(int startTime, int endTime) {

        NavigableMap<Integer, Integer> entries =
                map.subMap(startTime, true, endTime, true);

        int maximumValue = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : entries.entrySet()) {
            maximumValue = Math.max(maximumValue, entry.getValue());
        }

        return maximumValue;
    }

    public static void main(String[] args) {

        EventMax events = new EventMax();

        events.add(10, 50);
        events.add(5, 20);
        events.add(8, 70);
        events.add(10, 90);
        events.add(15, 40);

        System.out.println(events.getMax(5, 10));
        // 90
    }
}