//https://leetcode.com/problems/single-number/
//Interview Summary (1 line)
//Use XOR because duplicate numbers cancel out (a ^ a = 0), leaving only the unique number.

//Complexity
//Time:O(n)
//Space:O(1)
//one number once other number twice
package patterns.bit_manupulation;

public class SingleNumberI {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}