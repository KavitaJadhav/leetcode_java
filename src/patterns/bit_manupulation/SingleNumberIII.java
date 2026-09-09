//https://leetcode.com/problems/single-number-iii/submissions/1949025789/

//| Complexity     | Analysis                                                          |
//| -------------- | ----------------------------------------------------------------- |
//| **Time** O(n)  | Iterate the array **twice**: once for XOR, once for partition/XOR |
//| **Space** O(1) | Only a few integer variables; no extra arrays or hashmaps         |

//Approach (2–3 lines)
//XOR all numbers → get xor = a ^ b of the two uniques.
//Find a set bit in xor → partition numbers into two groups based on this bit.
//XOR each group → duplicates cancel, leaving the two unique numbers.

//Core Intuition
//The algorithm has 3 ideas:
//XOR all numbers → duplicates cancel
//Find a bit where the two unique numbers differ
//Split numbers into two groups using that bit

//exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.


package patterns.bit_manupulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xOr = nums[0];
        int[] res = new int[2];
        for (int index = 1; index < nums.length; index++) {
            xOr ^= nums[index];
        }

        int leastSetBit = xOr & -xOr;

        for (int num : nums) {
            if ((num & leastSetBit) == 0) res[0] ^= num;
            else res[1] ^= num;
        }

        return res;
    }
}

//num & -num - gives rightmost set bit
//-num = flip all bits + 1
