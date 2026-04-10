//https://leetcode.com/problems/house-robber/description/
//| Metric | Value |
//| ------ | ----- |
//| Time   | O(n)  |
//| Space  | O(n)  |

package patterns.dynamic_programming;

class HouseRobberI {
    public int rob(int[] nums) {
        int count = nums.length;
        if (count == 0) return 0;
        if (count == 1) return nums[0];

        int[] maxLoot = new int[count];
        maxLoot[0] = nums[0];
        maxLoot[1] = Math.max(nums[0], nums[1]);

        for (int index = 2; index < count; index++) {
            maxLoot[index] = Math.max(maxLoot[index - 1], maxLoot[index - 2] + nums[index]);
        }
        return maxLoot[count - 1];
    }
}

//Optimization
//O(1) space
class HouseRobberIOptimized {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}