//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | **O(n)**   |
//| Space  | **O(1)**   |

//Naive solution
// shift array elements by 1 position and add zero to end every time you encounter zero
//average/worst- O(N square)

package two_pointers;

class MoveZeroToEnd {
    public void moveZeroes(int[] nums) {
        int firstZeroIndex = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int tmp = nums[firstZeroIndex];
                nums[firstZeroIndex] = nums[right];
                nums[right] = tmp;
                firstZeroIndex++;
            }
        }
    }
}
//Optimization
//Avoid swap when both index are same


class MoveZeroToEndOptimised {
    class Solution {
        public void moveZeroes(int[] nums) {
            int firstZeroIndex = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] != 0) {
                    if (firstZeroIndex != right) {
                        int tmp = nums[firstZeroIndex];
                        nums[firstZeroIndex] = nums[right];
                        nums[right] = tmp;
                    }
                    firstZeroIndex++;
                }
            }
        }
    }
}