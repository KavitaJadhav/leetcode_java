package patterns.stream_processing;

import java.util.*;

public class AnomalyDetectionInOrder {
    private Integer threshold;
    private Integer window;
    private Map<String, Deque<Integer>> serviceEvents = new HashMap<>();

    public AnomalyDetectionInOrder(Integer threshold, Integer window) {
        this.threshold = threshold;
        this.window = window;
    }

    public boolean processEvent(String service, Integer time) {
        Integer startWindow = time - this.window;

        serviceEvents.putIfAbsent(service, new LinkedList<>());
        Deque<Integer> events = serviceEvents.get(service);

        while (!events.isEmpty() && events.getFirst() < startWindow) {
            events.removeFirst();
        }
        events.addLast( time);

        return events.size() > this.threshold;
    }

    public static void main(String[] args) {
        AnomalyDetectionInOrder solution = new AnomalyDetectionInOrder(3, 10);
        solution.processEvent("A", 1);
        solution.processEvent("A", 2);
        System.out.println(solution.processEvent("A", 3));
        System.out.println(solution.processEvent("A", 4));

        solution.processEvent("B", 1);
        solution.processEvent("B", 2);
        System.out.println(solution.processEvent("B", 3));
    }
}