//https://leetcode.com/problems/split-array-largest-sum/
//We binary search the answer between the maximum element and total array sum.
//For each candidate maximum sum, we greedily create subarrays and count how many are required.
//If more than k subarrays are needed, the candidate sum is too small, otherwise it is valid and we try to minimize it.

//Time Complexity:  O(n log(sum(nums)))
//Space Complexity: O(1)
//log(sum(nums)) = binary search space
//n = scan array each iteration

class Solution {
    public int splitArray(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        int min = Arrays.stream(nums).max().getAsInt();
        int max = total;

        while (min < max) {
            int mid = min + ((max - min) / 2);
            int index = 0;
            int subArrays = 1;
            int sum = 0;

            for (int num : nums) {
                if (sum + num > mid) {
                    subArrays++;
                    sum = num;
                } else {
                    sum += num;
                }
            }

            if (subArrays > k)
                min = mid + 1;
            else
                max = mid;
        }
        return max;
    }
}