package patterns.stream_processing.aggregation;

import java.util.*;
//Design a data structure to **add timestamped events that may arrive out of order** and return the **sum of all events in the previous 60 minutes** for a given timestamp.

//Complexity
//| Operation |          Complexity |
//| --------- | ------------------: |
//| `add()`   |        **O(log M)** |
//| `sum()`   | **O(M)** worst case |
//| Space     |            **O(M)** |
//
//`M` = number of distinct timestamps.

public class EventSum {
    int window;
    TreeMap<Integer, Long> map;

    public void add(int timeStamp, int value) {
        map.put(timeStamp, map.getOrDefault(timeStamp, 0L) + value);
    }

    public long sum(int endTime) {
        long sum = 0;
        int startTime = endTime - window;
        NavigableMap<Integer, Long> entries = map.subMap(startTime, true, endTime, true);

        for (Map.Entry<Integer, Long> entry : entries.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    public EventSum(int window) {
        this.window = window * 60; //convert minutes to seconds
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) {
        EventSum eventAverage = new EventSum(60);
        eventAverage.add(1, 10);
        System.out.println(eventAverage.sum(1));
        eventAverage.add(2, 10);
        System.out.println(eventAverage.sum(2));
        eventAverage.add(3, 10);
        System.out.println(eventAverage.sum(3));
        eventAverage.add(2, 30);
        System.out.println(eventAverage.sum(2));
        eventAverage.add(4, 20);
        System.out.println(eventAverage.sum(4));

    }
}
