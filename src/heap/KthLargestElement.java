//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

//Time Complexity
//Insert into heap → O(log k)
//Total operations → n
//Total = O(n log k)
//
//Space Complexity
//Heap size = k
//O(k)
//

//Why This Is Better Than Sorting
//Sorting approach:
//O(n log n)
//Heap approach:
//O(n log k)
//If k << n, heap is much faster.

//QuickSelect
//o(n log n)
package heap;

import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
//Optimization: Dont push element in heap if bigger that heap top;
//for (int num : nums) {
//        if (minHeap.size() < k) {
//        minHeap.offer(num);
//    } else if (num > minHeap.peek()) {
//        minHeap.poll();
//        minHeap.offer(num);
//    }
//            }