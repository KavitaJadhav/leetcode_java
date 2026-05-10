//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//⏱ Complexity
//Time → O(log n)
//Because we eliminate half each iteration.
//
//Space → O(1)
//Iterative. No recursion patterns.stack.

//⚠️ Small Improvement (Overflow Safe)
//Instead of: midIndex = (leftIndex + rightIndex) / 2;
//Safer: midIndex = leftIndex + (rightIndex - leftIndex) / 2;

package patterns.binary_search;

class RotatedArrayMinimum {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int midIndex;

        while (leftIndex < rightIndex) {
            midIndex = (leftIndex + rightIndex) / 2;

            if (nums[midIndex] > nums[rightIndex]) {
                // minimum is in right half
                leftIndex = midIndex + 1;
            } else {
                // minimum is at mid or left half
                rightIndex = midIndex;
            }
        }

        return nums[leftIndex];
    }
}