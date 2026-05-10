//https://leetcode.com/problems/contiguous-array/
//Given a binary array nums (only 0 and 1),
//👉 find the maximum length of a contiguous subarray with equal number of 0s and 1s.
//
package patterns.prefix_sum;

public class ContigiusArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        map.put(0, -1); // important: handles full prefix case

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }

        return maxLength;
    }
}