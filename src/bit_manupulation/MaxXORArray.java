//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

//| Type  | Complexity               |
//| ----- | ------------------------ |
//| Time  | **O(n × 32) ≈ O(n)**     |
//| Space | **O(n × 32)** Trie nodes |


//Interview Summary
//Build a binary trie of all numbers.
//For each number, greedily traverse the trie choosing the opposite bit to maximize XOR.

//Other solutions
//| Approach      | Time  | Space  | Interview Frequency |
//| ------------- | ----- | ------ | ------------------- |
//| Brute Force   | O(n²) | O(1)   | Rare                |
//| Greedy Prefix | O(n)  | O(n)   | ⭐ Very Common       | Todo: explore this solution
//| Trie          | O(n)  | O(32n) | ⭐⭐ Very Common      |

package bit_manupulation;

public class MaxXORArray {
    class Trie {
        Trie[] children = new Trie[2];
        int value;

        public void insert(int num) {
            Trie node = this;
            for (int index = 31; index >= 0; index--) {
                int bit = (num >> index) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new Trie();
                    node = node.children[bit];

                } else
                    node = node.children[bit];
            }
            node.value = num;
        }


        public int getClosest(int num) {
            Trie node = this;
            for (int index = 31; index >= 0; index--) {
                int bit = ((num >> index) & 1) ^ 1;

                if (node.children[bit] == null) {
                    node = node.children[Math.abs(bit - 1)];
                } else
                    node = node.children[bit];
            }
            return node.value;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();

        for (int num : nums) {
            root.insert(num);
        }

        int MaxDiff = 0;

        for (int num : nums) {
            MaxDiff = Math.max(MaxDiff, num ^ root.getClosest(num));
        }

        return MaxDiff;
    }
}