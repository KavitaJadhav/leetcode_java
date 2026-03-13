//https://leetcode.com/problems/house-robber-ii/
// | Metric | Value |
//| ------ | ----- |
//| Time   | O(n)  |
//| Space  | O(n)  |

package DynamicProgramming;

class HouseRobberII {
    public int rob(int[] nums) {
        int count = nums.length;
        if (count == 0) return 0;
        if (count == 1) return nums[0];


        int robFirst = robFromRange(nums, 0, count - 2);
        int robLast = robFromRange(nums, 1, count - 1);
        return Math.max(robFirst, robLast);
    }

    private int robFromRange(int[] nums, int start, int end) {
        // int count=0;
        if (start == end) return nums[start];
        // if(count==1) return nums[0];

        int[] maxLoot = new int[nums.length];
        maxLoot[start] = nums[start];
        maxLoot[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int index = start + 2; index <= end; index++) {
            maxLoot[index] = Math.max(maxLoot[index - 1], maxLoot[index - 2] + nums[index]);
        }
        return maxLoot[end];
    }
}