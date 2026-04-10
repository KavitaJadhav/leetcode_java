//Kadane’s Algorithm
//https://leetcode.com/problems/maximum-subarray/submissions/1915191020/
//https://www.youtube.com/watch?v=bJbfO4boNk4
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |

//Todo: implement below
//| Problem                                 | Official asks           | Returns |
//| --------------------------------------- | ----------------------- | ------- |
//| 53. Maximum Subarray                    | Max sum                 | int     |
//| 209. Minimum Size Subarray Sum          | Min length ≥ target     | int     |
//| 325. Maximum Size Subarray Sum Equals k | Max length with sum = k | int     |

//Kadane’s Algorithm (Greedy + DP)
//At each index, we decide whether to extend the current subarray or start a new one. We track the maximum sum seen so far, giving an O(n) solution.


package patterns.dynamic_programming.maximum_subarray;

class SubArrayMaxSum {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;

        int maxSum;
        int currentSum;

        maxSum= nums[0];
        currentSum= nums[0];

        for(int index=1; index < nums.length; index++){
            currentSum = Math.max(currentSum + nums[index], nums[index]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}