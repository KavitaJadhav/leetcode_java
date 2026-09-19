//https://leetcode.com/problems/sliding-window-median/?utm_source=chatgpt.com
package patterns.stream_processing.ranking;

import java.util.*;

public class MedianFinderSlidingWindow {


    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

    int minSize = 0;
    int maxSize = 0;

    Map<Integer, Integer> staleValue = new HashMap<>();

    public void addNum(int num) {

        prune(maxHeap);
        prune(minHeap);

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            maxSize++;
        } else {
            minHeap.offer(num);
            minSize++;
        }

        rebalance();
    }

    private void prune(PriorityQueue<Integer> heap) {

        while (!heap.isEmpty()) {

            int value = heap.peek();

            Integer count = staleValue.get(value);

            if (count == null) {
                break;
            }

            if (count == 1) {
                staleValue.remove(value);
            } else {
                staleValue.put(value, count - 1);
            }

            heap.poll();
        }
    }

    private void rebalance() {

        if (maxSize > minSize + 1) {

            prune(maxHeap);

            Integer value = maxHeap.poll();

            maxSize--;
            minSize++;

            minHeap.offer(value);

        } else if (minSize > maxSize) {

            prune(minHeap);

            Integer value = minHeap.poll();

            minSize--;
            maxSize++;

            maxHeap.offer(value);
        }
    }

    public void remove(int num) {

        prune(maxHeap);
        prune(minHeap);

        staleValue.put(
                num,
                staleValue.getOrDefault(num, 0) + 1
        );

        if (!maxHeap.isEmpty() && num <= maxHeap.peek()) {
            maxSize--;
        } else {
            minSize--;
        }

        prune(maxHeap);
        prune(minHeap);

        rebalance();
    }

    public double median() {

        prune(maxHeap);
        prune(minHeap);

        if (maxSize + minSize == 0) {
            return 0.0;
        }

        if (maxSize == minSize) {
            return ((long) maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        // First window
        for (int index = 0; index < k; index++) {
            addNum(nums[index]);
        }

        result[0] = median();

        // Slide window
        for (int index = k; index < nums.length; index++) {

            remove(nums[index - k]);

            addNum(nums[index]);

            result[index - k + 1] = median();
        }

        return result;
    }

    public static void main(String[] args) {

        MedianFinderSlidingWindow solution = new MedianFinderSlidingWindow();

        System.out.println(
                Arrays.toString(solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
        );
        // [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]

    }
}

