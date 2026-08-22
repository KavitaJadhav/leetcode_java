package patterns.heap.median;

import java.util.*;

public class RunningMedian {

    public ArrayList<Integer> solve(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(numbers.get(0));
        result.add(numbers.get(0));

        for (int index = 1; index < numbers.size(); index++) {
            int number = numbers.get(index);

            if (number > minHeap.peek()) {
                minHeap.offer(number);
            } else {
                maxHeap.offer(number);
            }

            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            int diff = maxHeapSize - minHeapSize;

            if (diff > 1) {
                minHeap.offer(maxHeap.poll());
            } else if (diff < 0) {
                maxHeap.offer(minHeap.poll());
            }
            result.add(maxHeap.peek());
        }
        return result;
    }
}

