//https://leetcode.com/problems/total-hamming-distance/

//| Metric | Complexity           |
//| ------ | -------------------- |
//| Time   | **O(32 × n) ≈ O(n)** |
//| Space  | **O(1)**             |

//Interview Summary
//For Total Hamming Distance, compute contribution bit-by-bit instead of pair-by-pair.
//If a bit has k ones and n-k zeros, it contributes k × (n-k) to the total Hamming distance.

//| Approach                   | Idea                                              | Time Complexity | Space Complexity | Interview Use   |
//| -------------------------- | ------------------------------------------------- | --------------- | ---------------- | --------------- |
//| Brute Force                | Compute Hamming distance for every pair using XOR | O(n² × 32)      | O(1)             | ❌ Too slow      |
//| Pairwise XOR + Bit Count   | XOR each pair then count set bits                 | O(n² × 32)      | O(1)             | ❌ Same as brute |
//| Bit Contribution (Optimal) | Count 1s and 0s for each bit                      | **O(32 × n)**   | O(1)             | ⭐ Expected      |

package patterns.bit_manupulation;

public class ArrayHammingSum {

    public int totalHammingDistance(int[] nums) {

        int result = 0;
        for (int index = 0; index < 32; index++) {
            int zero = 0;
            int one = 0;

            for (int num : nums) {
                int bit = (num >> index) & 1;
                if (bit == 0) zero++;
                else one++;
            }
            result += (one * zero);
        }

        return result;
    }

    public static void main(String[] args) {
//        Todo: revisit answer
        System.out.println(new ArrayHammingSum().totalHammingDistance(new int[]{1,2,3,4}));
//      Ans -   11
        System.out.println(new ArrayHammingSum().totalHammingDistance(new int[]{1,2}));
        System.out.println(new ArrayHammingSum().totalHammingDistance(new int[]{1,2,3}));

    }
}