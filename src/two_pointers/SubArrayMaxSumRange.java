//| Metric | Complexity            |
//| ------ | --------------------- |
//| Time   | O(n)                  |
//| Space  | O(n) for output array |

//“This is Kadane’s algorithm with index tracking. We track the start of the current subarray and update global start/end indices whenever we find a better sum.”

package two_pointers;

import java.util.*;

class SubArrayMaxSumRange {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int startIndex, endIndex, maxStartIndex;
        int maxSum;
        int currentSum;

        maxSum = currentSum = nums[0];
        startIndex = endIndex = maxStartIndex = 0;

        for (int index = 1; index < nums.length; index++) {
            if (currentSum + nums[index] > nums[index]) {
                currentSum = currentSum + nums[index];

            } else {
                currentSum = nums[index];
                startIndex = index;
            }

            if (currentSum > maxSum) {
                maxStartIndex = startIndex;
                maxSum = currentSum;
                endIndex = index;
            }
        }
        int[] res = Arrays.copyOfRange(nums, maxStartIndex, endIndex + 1);
        System.out.println(Arrays.toString(res));
        return maxSum;
    }
}
