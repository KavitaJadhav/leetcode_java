//https://leetcode.com/problems/missing-number

//Complexity
//Time: O(n) (two passes)
//Space: O(1)

//Interview Summary (1–2 lines):
//XOR all numbers from 0 to n with all array elements; duplicates cancel, leaving the missing number.

package patterns.bit_manupulation;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;

        for (int num = 1; num <= nums.length; num++) {
            result ^= num;
        }

        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}