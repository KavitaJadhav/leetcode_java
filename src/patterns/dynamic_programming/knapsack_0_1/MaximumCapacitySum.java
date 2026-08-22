package patterns.dynamic_programming.knapsack_0_1;

import java.util.ArrayList;

public class MaximumCapacitySum {
    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity) {
        int rows = values.size();
        if (rows == 0 || capacity == 0)
            return 0;
        int[][] dp = new int[rows + 1][capacity + 1];

        for (int row = 1; row <= rows; row++) {
            for (int dpCapacity = 1; dpCapacity <= capacity; dpCapacity++) {
                int weight = weights.get(row - 1);
                int value = values.get(row - 1);
                if (weight <= dpCapacity) {
                    dp[row][dpCapacity] = Math.max(dp[row - 1][dpCapacity - weight] + value, dp[row - 1][dpCapacity]);
                } else {
                    dp[row][dpCapacity] = dp[row - 1][dpCapacity];
                }
                // System.out.print(", "+dp[row][dpCapacity]);
            }
        }

        return dp[rows][capacity];
    }
}

//  A = [60, 100, 120]
//  B = [1, 2, 3]
//  C = 5
// dp
// 0,1,2,3,4,5
// 0,0,0,0,0,0
// 0,60,60,60,60,60
// 0,60,100,160,160,160
// 0,60, 100, 160, 180, 220