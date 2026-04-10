//https://leetcode.com/problems/number-of-1-bits/

// Interview Summary (2–3 lines):
//Count number of 1 bits using either shift & count (O(32)) or using n & (n-1) to remove the last 1-bit repeatedly (O(# of 1s)).

//Approach 2: Brian Kernighan’s Trick (faster for sparse 1’s)
//Each iteration removes one 1-bit
//Time: O(number of 1s)
//Space: O(1)

package patterns.bit_manupulation;

public class NumberOf1s {

    public int hammingWeight(int n) {
        int result = 0;

        while(n!=0){
            // n = n&(n-1);
            n &= (n-1);
            result++;
        }
        return result;
    }
}
//n = 11 (1011)
//Step 1: 1011 & 1010 = 1010 → count = 1
//Step 2: 1010 & 1001 = 1000 → count = 2
//Step 3: 1000 & 0111 = 0000 → count = 3
//Done

//Approach 1: Shift & Count
//n & 1 → extracts the least significant bit
//>>> → unsigned right shift to avoid sign extension
//Complexity:
//Time: O(32) → constant for 32-bit integer
//Space: O(1)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += (n & 1);  // check last bit
            n = n >>> 1;       // unsigned right shift
        }
        return count;
    }
}