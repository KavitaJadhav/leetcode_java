package patterns.stream_processing.aggregation;
//TreeMap + ArrayList
import java.util.*;
//Question
//Get average of last k events.. events can receive out of order

//Let:
//
//M = number of distinct timestamps
//E = total number of events
//N = requested size (number of most recent events to average)
//
//Summary
//Operation	Complexity
//add()	O(log M)
//average()	O(M + N) worst case
//Space	O(E)
//
public class EventAverage {
    int size;
    TreeMap<Integer, ArrayList<Integer>> map;

    public void add(int timeStamp, int value) {
        map.computeIfAbsent(timeStamp, key -> new ArrayList<>()).add(value);
    }

    public double average(int timestamp) {
        NavigableMap<Integer, ArrayList<Integer>> entries = map.headMap(timestamp, true).descendingMap();
        long sum = 0;
        int count = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : entries.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            for (int index = list.size() - 1; index >= 0 && count < size; index--) {
                sum += list.get(index);
                count++;
            }
            if (count == size)
                break;
        }
        if (count == 0)
            return 0.0;
        return (double) sum / count;
    }

    public EventAverage(int size) {
        this.size = size;
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) {
        EventAverage eventAverage = new EventAverage(3);
        eventAverage.add(1, 10);
        System.out.println(eventAverage.average(1));
        eventAverage.add(2, 10);
        System.out.println(eventAverage.average(2));
        eventAverage.add(3, 10);
        System.out.println(eventAverage.average(3));
        eventAverage.add(2, 30);
        System.out.println(eventAverage.average(2));
        eventAverage.add(4, 20);
        System.out.println(eventAverage.average(4));

    }
}
