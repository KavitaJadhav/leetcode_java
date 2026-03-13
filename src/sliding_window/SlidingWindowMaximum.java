//https://leetcode.com/problems/sliding-window-maximum/
//https://github.com/KavitaJadhav/data_structure_questions/blob/main/ds_patterns/sliding_window/sliding_window_maximum.rb

//⏱ Complexity (what interviewers want)
//Time: O(n)
//Space: O(k)
//Reason:
//Each index enters deque once
//Each index leaves deque once
//Amortized O(n).

//Interview-level explanation (what you should say)
//We maintain a monotonic decreasing deque of indices.
//For every new element we remove smaller elements from the back because they cannot be the maximum anymore.
//The front of the deque always contains the index of the maximum element in the current window.
//When the window moves, we remove indices that fall outside the window.

//Monotonic stacks and queues optimize problems to by maintaining ordered elements.
//Use a Monotonic Stack(LIFO)to find the next/previous greater/smaller element
//(e.g.,daily temperatures).Use a Monotonic Queue(Deque-FIFO)to find the maximum/minimum value in a sliding window.

        package sliding_window;

import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int resultSize = nums.length - k + 1;
        int[] result = new int[resultSize];

        int left = 0;
        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {
            // [-1,-2,-3,-4, -5]
            // [-1,-2,-3,-4] ]
            // [-1,  ]

            while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
                queue.removeLast();
            }

            queue.addLast(right);

            while (!queue.isEmpty() && queue.getFirst() < left) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                result[resultIndex++] = nums[queue.getFirst()];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}