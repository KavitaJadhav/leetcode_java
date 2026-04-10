//https://leetcode.com/problems/missing-number

//Complexity
//Time: O(n) (two passes)
//Space: O(1)

//Interview Summary (1–2 lines):
//sum-arraysum

package patterns.bit_manupulation;

class MissingNumberSum {
    public int missingNumber(int[] nums) {
        int totalSum = nums.length * (nums.length + 1) / 2;
        int inputSum = 0;

        for (int num : nums) {
            inputSum += num;
        }
        return totalSum - inputSum;
    }
}