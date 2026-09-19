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

package patterns.stream_processing;

public class MovingAverageArray {
    private int size;
    private long runningSum;
    private int nextIndex;
    private int currentSize;
    private int[] values;

    public MovingAverageArray(int size) {
        if (size <= 0) throw new IllegalArgumentException("Invalid Window size");
        this.size = size;
        this.currentSize = 0;
        this.runningSum = 0;

        this.nextIndex = 0;
        this.values = new int[size];
    }

    public double next(int val) {
        if (currentSize < size) {
            currentSize++;
        } else {
            runningSum -= values[nextIndex];
        }
        values[nextIndex] = val;
        nextIndex++;
        nextIndex %= size;
        runningSum += val;
        return (double) runningSum / currentSize;

    }

    public static void main(String[] args) {
        MovingAverageArray movingAverage = new MovingAverageArray(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
        MovingAverageArray movingAverageInvalid = new MovingAverageArray(0);
    }
}
