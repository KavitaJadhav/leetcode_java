//https://www.scaler.com/academy/mentee-dashboard/class/514053/assignment/problems/9340/?navref=cl_pb_nv_tb
package patterns.dynamic_programming.knapsack_unbounded;

import java.util.ArrayList;

public class MaximumCapacitySum {
    public int solve(int targetWeight, ArrayList<Integer> values, ArrayList<Integer> weights) {
        if (targetWeight == 0 || values.size() == 0)
            return 0;
        int[] dp = new int[targetWeight + 1];
        dp[0] = 0;

        for (int index = 0; index < values.size(); index++) {
            int value = values.get(index);
            int weight = weights.get(index);

            for (int dpTarget = 1; dpTarget <= targetWeight; dpTarget++) {
                if (weight <= dpTarget) {
                    dp[dpTarget] = Math.max(dp[dpTarget], value + dp[dpTarget - weight]);
                }
            }
        }
        return dp[targetWeight];
    }
}
//Todo: Validate dp calculation again
// A = 10
// B = [6, 7]
// C = [5, 5]

// dp
// 0,1,2,3,4,5,6,7,8,9,10
// 0,0,0,0,0,6,6,6,6,6,12
// 0,0,0,0,0,7,7,7,7,7,14
