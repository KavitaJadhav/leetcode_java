//Given an array nums and integer k,
//count the number of subarrays whose sum is divisible by k
//https://leetcode.com/problems/subarray-sums-divisible-by-k/

package mock_practice;

import java.util.HashMap;

public class SubarrayDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int mod = sum % k;

            // fix negative remainder
            if (mod < 0) mod += k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public int subarraysDivByKOtimised(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0] = 1;

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            int mod = sum % k;
            if (mod < 0) mod += k;

            count += freq[mod];
            freq[mod]++;
        }

        return count;
    }
}