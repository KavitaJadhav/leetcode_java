//https://leetcode.com/problems/majority-element/
//Element that appears the maximum number of times and at least ⌊n/2⌋ times
//Optimal Solution: Boyer-Moore Voting Algorithm
// Idea (Intuition)
//If an element appears more than n/2 times, it will dominate others
//We cancel out different elements

package mock_practice;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    //If NOT guaranteed → Need Validation Pass
    public int majorityElementNotGareeteed(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        // verify
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 2 ? candidate : -1;
    }
}

//Todo: understand
//. Elements appearing > n/3 times
//Key Insight
//There can be at most 2 elements appearing more than ⌊n/3⌋ times
//👉 (because 3 such elements would exceed n)
class MajorityElement1 {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Find candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);

        return result;
    }
}

//Todo: understand
//General Case: Elements appearing > n/k times
//🔑 Key Insight
//At most k-1 elements can appear more than ⌊n/k⌋ times
class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / k) {
                result.add(key);
            }
        }

        return result;
    }
}