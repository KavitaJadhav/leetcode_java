package patterns.stream_processing.aggregation;

//Design a data structure to add timestamped events that may arrive out of order and return the number of events in the previous K minutes for a given timestamp.

//Complexity
//add() → O(log M)
//count() → O(R), worst case O(M)
//Space → O(M)
//M = distinct timestamps, R = distinct timestamps inside the queried window.

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class EventCount {

    int window;
    TreeMap<Integer, Integer> map;

    public EventCount(int window) {
        this.window = window * 60; // minutes → seconds
        this.map = new TreeMap<>();
    }

    public void add(int timeStamp) {
        map.put(timeStamp, map.getOrDefault(timeStamp, 0) + 1);
    }

    public int count(int endTime) {

        int startTime = endTime - window;

        NavigableMap<Integer, Integer> entries =
                map.subMap(startTime, true, endTime, true);

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : entries.entrySet()) {
            count += entry.getValue();
        }

        return count;
    }

    public static void main(String[] args) {

        EventCount eventCount = new EventCount(60);

        eventCount.add(1);
        eventCount.add(2);
        eventCount.add(3);
        eventCount.add(2);

        System.out.println(eventCount.count(3));
        // 4
    }
}
