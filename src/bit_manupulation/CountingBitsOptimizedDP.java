//https://leetcode.com/problems/counting-bits/

//Complexity
//Time: O(n) → each number is processed once
//Space: O(n) → array to store results

//Summary
//Use DP: ans[i] = ans[i >> 1] + (i & 1); shift right removes last bit, add 1 if last bit is set. O(n) time, O(n) space.
package bit_manupulation;

public class CountingBitsOptimizedDP {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0; //base case
        for (int index = 1; index <= n; index++) {
            result[index] = result[index >> 1] + (index & 1);
        }
        return result;
    }
}