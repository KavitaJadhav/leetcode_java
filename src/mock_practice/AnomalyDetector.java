
package mock_practice;

public class AnomalyDetector {


    private final int windowSize;
    private final int threshold;

    private Map<String, Deque<Long>> map = new HashMap<>();

    public AnomalyDetector(int windowSize, int threshold) {
        this.windowSize = windowSize;
        this.threshold = threshold;
    }

    public boolean processEvent(String serviceId, long timestamp) {
        map.putIfAbsent(serviceId, new LinkedList<>());
        Deque<Long> q = map.get(serviceId);

        // add new event
        q.addLast(timestamp);

        // remove old events outside window
        while (!q.isEmpty() && timestamp - q.peekFirst() > windowSize) {
            q.pollFirst();
        }

        // detect spike
        if (q.size() > threshold) {
            return true; // anomaly detected
        }

        return false;
    }

    public class Main {
        public static void main(String[] args) {
            AnomalyDetector detector = new AnomalyDetector(10, 3);

            System.out.println(detector.processEvent("A", 100)); // false
            System.out.println(detector.processEvent("A", 101)); // false
            System.out.println(detector.processEvent("A", 102)); // false
            System.out.println(detector.processEvent("A", 103)); // true (spike)
        }
    }

}
