//https://leetcode.com/problems/longest-increasing-subsequence/
//| Metric | Value |
//| ------ | ----- |
//| Time   | O(n²) |
//| Space  | O(n)  |


        package patterns.dynamic_programming;

import java.util.*;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        // [0,1,0,3,2,3]
        // [1,1,1,1,1,1]

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int iIndex = nums.length - 1; iIndex >= 0; iIndex--) {
            for (int jIndex = iIndex + 1; jIndex < nums.length; jIndex++) {
                if (nums[iIndex] < nums[jIndex]) result[iIndex] = Math.max(result[iIndex], 1 + result[jIndex]);
            }
        }
        int max = 1;
        for (int lis : result) {
            if (lis > max) max = lis;
        }
        return max;
    }
}