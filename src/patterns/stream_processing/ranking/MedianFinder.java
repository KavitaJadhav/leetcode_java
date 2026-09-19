//https://leetcode.com/problems/find-median-from-data-stream/description/
package patterns.stream_processing.ranking;

import java.util.*;

//Complexity
//Time
//addNum() - O(log N)
//
//findMedian() - O(1)
//
//Space
//O(N)
//
//Interview takeaway
//The two-heaps pattern maintains:
//maxHeap → lower half of numbers.
//minHeap → upper half of numbers.
//maxHeap.size() is equal to or one greater than minHeap.size().


public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (!minHeap.isEmpty() && num >= minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        rebalance();
    }

    private void rebalance() {
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        if (minHeap.size() + 1 < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        int totalElements = minHeap.size() + maxHeap.size();
        // System.out.print(" min "+minHeap.size()+" max "+ maxHeap.size());
        if (totalElements == 0)
            return 0.0;
        double result;
        if (totalElements % 2 == 0) {
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            result = maxHeap.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // 5.0

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 3.5

        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian()); // 5.0

        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian()); // 4.5

        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian()); // 5.0
    }
}
//values from 0 to 100
 class MedianFinderRange {

    private int[] frequency;
    private int totalElements;

    public MedianFinderRange() {
        frequency = new int[101];
        totalElements = 0;
    }

    public void addNum(int num) {
        frequency[num]++;
        totalElements++;
    }

    public double findMedian() {
        int firstMiddlePosition = (totalElements + 1) / 2;
        int secondMiddlePosition = (totalElements + 2) / 2;

        int firstMiddleValue = -1;
        int secondMiddleValue = -1;

        int cumulativeCount = 0;

        for (int num = 0; num <= 100; num++) {
            cumulativeCount += frequency[num];

            if (firstMiddleValue == -1 &&
                    cumulativeCount >= firstMiddlePosition) {
                firstMiddleValue = num;
            }

            if (cumulativeCount >= secondMiddlePosition) {
                secondMiddleValue = num;
                break;
            }
        }

        return (firstMiddleValue + secondMiddleValue) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // 5.0

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 3.5

        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian()); // 5.0

        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian()); // 4.5

        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian()); // 5.0
    }
}

 class MedianFinderRangeOutliers {

    private int[] frequency;
    private int lowerCount;
    private int middleCount;
    private int upperCount;

    private PriorityQueue<Integer> lowerOutliers;
    private PriorityQueue<Integer> upperOutliers;

    public MedianFinderRangeOutliers() {
        frequency = new int[101];

        lowerOutliers = new PriorityQueue<>(Collections.reverseOrder());
        upperOutliers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (num < 0) {
            lowerOutliers.offer(num);
            lowerCount++;
        } else if (num > 100) {
            upperOutliers.offer(num);
            upperCount++;
        } else {
            frequency[num]++;
            middleCount++;
        }
    }

    public double findMedian() {
        int totalElements = lowerCount + middleCount + upperCount;

        int firstMiddlePosition = (totalElements + 1) / 2;
        int secondMiddlePosition = (totalElements + 2) / 2;

        int firstValue = findKth(firstMiddlePosition);
        int secondValue = findKth(secondMiddlePosition);

        return (firstValue + secondValue) / 2.0;
    }

    private int findKth(int position) {

        // Median is in negative outliers
        if (position <= lowerCount) {
            return findKthInMaxHeap(position);
        }

        // Median is in [0, 100]
        position -= lowerCount;

        if (position <= middleCount) {
            int cumulativeCount = 0;

            for (int num = 0; num <= 100; num++) {
                cumulativeCount += frequency[num];

                if (cumulativeCount >= position) {
                    return num;
                }
            }
        }

        // Median is in positive outliers
        position -= middleCount;

        return findKthInMinHeap(position);
    }

    /*
     * Since lowerOutliers is a max heap, finding arbitrary kth
     * requires more work. For the 1% outliers, copying and sorting
     * is still small, but this is not ideal for repeated median calls.
     */
    private int findKthInMaxHeap(int position) {
        List<Integer> values = new ArrayList<>(lowerOutliers);
        values.sort(Collections.reverseOrder());
        return values.get(position - 1);
    }

    private int findKthInMinHeap(int position) {
        List<Integer> values = new ArrayList<>(upperOutliers);
        Collections.sort(values);
        return values.get(position - 1);
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(5);
        medianFinder.addNum(2);
        medianFinder.addNum(10);
        medianFinder.addNum(4);
        medianFinder.addNum(8);

        System.out.println(medianFinder.findMedian()); // 5.0

        medianFinder.addNum(-10);
        medianFinder.addNum(150);

        System.out.println(medianFinder.findMedian()); // 5.0
    }
}