//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

//| Type  | Complexity               |
//| ----- | ------------------------ |
//| Time  | **O(n × 32) ≈ O(n)**     |
//| Space | **O(n × 32)** Trie nodes |


//Interview Summary
//Build a binary patterns.trie of all numbers.
//For each number, greedily traverse the patterns.trie choosing the opposite bit to maximize XOR.

//Other solutions
//| Approach      | Time  | Space  | Interview Frequency |
//| ------------- | ----- | ------ | ------------------- |
//| Brute Force   | O(n²) | O(1)   | Rare                |
//| Greedy Prefix | O(n)  | O(n)   | ⭐ Very Common       | Todo: explore this solution
//| Trie          | O(n)  | O(32n) | ⭐⭐ Very Common      |

package patterns.bit_manupulation;

public class MaxANDArray {
    public int solve(ArrayList<Integer> values) {

        int result = 0;
        int candidate = 0;
        for(int index = 31; index >=0; index--){
            candidate +=  Math.pow(2, index);

            int count = 0;
            for(int value : values){
                if((value & candidate) == candidate){
                    count++;
                }
            }
            if(count>=2){
                result = candidate;
            }
            candidate=result;
            // System.out.print(" count" + count + "candidate "+ candidate);
        }
        return result;
    }
}