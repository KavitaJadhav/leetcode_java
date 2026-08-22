//Todo: Understand this solution
//| Method             | Time       | Space |
//| ------------------ | ---------- | ----- |
//| DP (your solution) | O(n²)      | O(n)  |
//| Binary search LIS  | O(n log n) | O(n)  |

        package patterns.dynamic_programming.subsequenses;

class LongestIncreasingSubsequenceOptimized {
    public int lengthOfLIS(int[] nums) {

        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {

            int left = 0;
            int right = size;

            while (left < right) {
                int mid = (left + right) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;

            if (left == size) size++;
        }

        return size;
    }
}