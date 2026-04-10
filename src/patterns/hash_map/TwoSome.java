//https://leetcode.com/problems/two-sum/
//| Resource | Complexity |
//| -------- | ---------- |
//| Time     | O(N)       |
//| Space    | O(N)       |

        package patterns.hash_map;

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