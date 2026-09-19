//https://leetcode.com/problems/moving-average-from-data-stream/description/
//1. Problem statement
//Design a class that calculates the moving average of all integers in a sliding window of size size.
//
//Implement:
//MovingAverage(int size) — initializes the object with the window size.
//double next(int val) — adds a new value and returns the moving average of the last size values.
//
//Example
//size = 3
//
//next(1) → 1.0
//next(10) → 5.5
//next(3) → 4.66667
//next(5) → 6.0

package patterns.stream_processing.aggregation;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private int size;
    private long runningSum;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        if(size<=0) throw new IllegalArgumentException("Invalid Window size");
        this.size = size;
        this.runningSum = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.offer(val);
        runningSum += val;

        if (queue.size() > size) {
            runningSum -= queue.poll();
        }
        return (double) runningSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
        MovingAverage movingAverageInvalid = new MovingAverage(0);
    }
}
