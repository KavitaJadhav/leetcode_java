//https://leetcode.com/problems/reverse-bits/description/
//Complexity
//Time: O(32) → constant
//Space: O(1)

package patterns.bit_manupulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int count = 0; count < 32; count++) {
            result <<= 1; //Adding tailing space(0) to accommodate a new bit
            result |= (n & 1); // finding last digit value (0/1). by & with 1(i.e. 0001)
            n >>>= 1; //shifting last index and reassigning remaining value to n
        }

//        for (int index = 0; index < 32; index++) {
//            result <<= 1;
//            result |= (n >> index) & 1;
//        }
        return result;
    }
}

//Todo: understand this approach
//Approach 2: Divide & Conquer (faster with masks)
//You can also reverse bits in parallel using bit masks and shifts (useful if called multiple times):

class Solution1 {
    public int reverse(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}

//Uses bit masks to swap halves → much faster in bulk calls.
//Interview Summary (2–3 lines):
//Reverse bits by shifting result left and appending LSB of n. Repeat 32 times. For optimization, use divide-and-conquer bit masks for parallel swapping.
