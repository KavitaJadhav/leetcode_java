package patterns.stream_processing;

import java.util.*;

public class AnomalyDetectionNoOrder {
    private Integer threshold;
    private Integer window;
    private Map<String, TreeMap<Integer, Integer>> serviceEvents = new HashMap<>();

    public AnomalyDetectionNoOrder(Integer threshold, Integer window) {
        this.threshold = threshold;
        this.window = window;
    }

    public boolean processEvent(String service, Integer time) {

        serviceEvents.putIfAbsent(service, new TreeMap<>());
        TreeMap<Integer, Integer> events = serviceEvents.get(service);
        Integer startWindow = time - this.window;
        //Note can use event.last time here.. manage exception
        events.put(time, events.getOrDefault(time, 0) + 1);
        NavigableMap<Integer, Integer> windowEvents = events.subMap(startWindow, true, time, true);
        int count = 0;
        for (int value : windowEvents.values()) {
            count += value;
        }
        return count > this.threshold;
    }

    public static void main(String[] args) {
        AnomalyDetectionNoOrder solution = new AnomalyDetectionNoOrder(3, 10);
        solution.processEvent("A", 1);
        solution.processEvent("A", 2);
        System.out.println(solution.processEvent("A", 3));
        System.out.println(solution.processEvent("A", 4));

        solution.processEvent("B", 3);
        solution.processEvent("B", 2);
        System.out.println(solution.processEvent("B", 1));
    }
}