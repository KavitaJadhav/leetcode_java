//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1945133280/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | **O(n)**   |
//| Space  | **O(1)**   |

//Naive Solution (Brute Force)
//Check all pairs (i, j) and see if their sum equals the target.
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | **O(n²)**  |
//| Space  | **O(1)**   |

package two_pointers;


class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (numbers[left] + numbers[right] == target) break;

            if (sum > target) right--;
            else left++;
        }


        return new int[]{left + 1, right + 1};
    }
}
