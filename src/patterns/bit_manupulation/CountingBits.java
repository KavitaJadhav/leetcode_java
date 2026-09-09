//https://leetcode.com/problems/counting-bits/description/
//Question - return array indicating count of set bits upto N;
// Approach
//Create an array result of length n + 1.
//For each number 0..n, compute the number of set bits using Brian Kernighan’s trick:

//Time: O(n * k), where k = number of set bits in each number
//In worst case, k ≤ log(n) (number of bits in n)
//Space: O(n) for the result array

package patterns.bit_manupulation;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int index = 0; index <= n; index++){
            result[index] = hammingWeight(index);
        }
        return result;
    }
    public int hammingWeight(int n) {
        int result = 0;

        while(n!=0){
            // n = n&(n-1);
            n &= (n-1);
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString( new CountingBits().countBits(10)));
//
    }
}