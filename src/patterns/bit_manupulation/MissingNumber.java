//https://www.scaler.com/academy/mentee-dashboard/class/514022/assignment/problems/19558/submissions
//Maximum AND: Greedily build the answer from the highest bit to the lowest, keeping a bit only if at least two numbers contain all bits currently selected.

//Time: O(32 × N) → O(N)
//Space: O(1)
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