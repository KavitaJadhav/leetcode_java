//https://leetcode.com/problems/two-sum/
//| Resource | Complexity |
//| -------- | ---------- |
//| Time     | O(N)       |
//| Space    | O(N)       |

package patterns.hash_map;

import java.util.*;

class TwoSome {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
// [2,7,11,15]
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];

            if (complements.containsKey(complement)) {
                return new int[]{complements.get(complement), index};
            } else {
                complements.put(nums[index], index);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
//Todo: explore these
 List<List<Integer>> twoSumUniquePairs(int[] nums, int target) {
    Set<Integer> seen = new HashSet<>();
    Set<String> uniquePairs = new HashSet<>();

    List<List<Integer>> result = new ArrayList<>();

    for (int number : nums) {
        int needed = target - number;

        if (seen.contains(needed)) {
            int smaller = Math.min(number, needed);
            int larger = Math.max(number, needed);

            String key = smaller + "," + larger;

            if (uniquePairs.add(key)) {
                result.add(Arrays.asList(smaller, larger));
            }
        }

        seen.add(number);
    }

    return result;
}

 List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    for (int first = 0; first < nums.length; first++) {
        Set<Integer> seen = new HashSet<>();

        for (int second = first + 1; second < nums.length; second++) {
            int needed = -nums[first] - nums[second];

            if (seen.contains(needed)) {
                result.add(Arrays.asList(
                        nums[first],
                        nums[second],
                        needed
                ));
            }

            seen.add(nums[second]);
        }
    }

    return result;
}

boolean fourSumExists(int[] nums, int target) {
    Map<Integer, List<int[]>> pairSums = new HashMap<>();

    for (int first = 0; first < nums.length; first++) {
        for (int second = first + 1; second < nums.length; second++) {

            int pairSum = nums[first] + nums[second];

            if (pairSums.containsKey(target - pairSum)) {
                for (int[] pair : pairSums.get(target - pairSum)) {
                    if (pair[0] != first &&
                            pair[0] != second &&
                            pair[1] != first &&
                            pair[1] != second) {
                        return true;
                    }
                }
            }

            pairSums
                    .computeIfAbsent(pairSum, key -> new ArrayList<>())
                    .add(new int[] {first, second});
        }
    }

    return false;
}