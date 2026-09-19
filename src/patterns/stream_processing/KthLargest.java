package patterns.stream_processing;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/?utm_source=chatgpt.com
//You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.
//
//Implement the KthLargest class:
//
//KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
//int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/?utm_source=chatgpt.com
import java.util.*;
//Complexity
//Time
//Constructor O(N log K)
//add() O(log K)
//Space
//O(K)

//Why do we use a min-heap for Kth Largest instead of a max-heap?
//Think about the invariant: we retain only the K largest elements, and the smallest among them is the Kth largest.
public class KthLargest {
    int k;

    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println(kthLargest.add(3));   // 4
        System.out.println(kthLargest.add(5));   // 5
        System.out.println(kthLargest.add(10));  // 5
        System.out.println(kthLargest.add(9));   // 8
        System.out.println(kthLargest.add(4));   // 8
    }
}