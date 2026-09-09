package patterns.binary_search.bsOnAnswer;
//Split given arrays into k subarrays such that max sub array sum will be maximized
//https://leetcode.com/problems/split-array-largest-sum/
//We binary search the answer between the maximum element and total array sum.
//For each candidate maximum sum, we greedily create subarrays and count how many are required.
//If more than k subarrays are needed, the candidate sum is too small, otherwise it is valid and we try to minimize it.

//Time Complexity:  O(n log(sum(nums)))
//Space Complexity: O(1)
//log(sum(nums)) = binary search space
//n = scan array each iteration
import java.util.*;
//ShipPackagesDDays().shipWithinDays

class ArraySplitSumLarge {
    public int splitArray(int[] nums, int k) {
        int min = Arrays.stream(nums).max().getAsInt();
        int max = Arrays.stream(nums).sum();

        while (min < max) {
            int mid = min + ((max - min) / 2);
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
    public static void main(String[] args) {
        System.out.println(new ArraySplitSumLarge().splitArray(new int[] {3,5,8,5}, 5));
        System.out.println(new ArraySplitSumLarge().splitArray(new int[] {3,5,8,5,5}, 5));
        System.out.println(new ArraySplitSumLarge().splitArray(new int[] {3,5,8,5,5,5}, 5));
        System.out.println(new ArraySplitSumLarge().splitArray(new int[] {3,5,8,5,5,5,5}, 5));
//        8
//        8
//        8
//        10
    }
}