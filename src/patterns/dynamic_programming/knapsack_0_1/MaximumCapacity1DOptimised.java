//https://www.scaler.com/academy/mentee-dashboard/class/514056/assignment/problems/9347/submissions
package patterns.dynamic_programming.knapsack_0_1;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumCapacity1DOptimised {
//     Todo: revisit and reimplement
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size();

        int totalValue = 0;
        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            totalValue += A.get(i);
            totalWeight += B.get(i);
        }

        // All items can be selected
        if (totalWeight <= C) {
            return totalValue;
        }

        // dp[value] = minimum weight required to achieve 'value'
        int maxValue = totalValue;
        int INF = Integer.MAX_VALUE;

        int[] dp = new int[maxValue + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int value = A.get(i);
            int weight = B.get(i);

            // 0/1 Knapsack -> iterate backwards
            for (int v = maxValue; v >= value; v--) {
                if (dp[v - value] != INF) {
                    dp[v] = Math.min(
                            dp[v],
                            dp[v - value] + weight
                    );
                }
            }
        }

        // Find maximum achievable value within capacity
        for (int v = maxValue; v >= 0; v--) {
            if (dp[v] <= C) {
                return v;
            }
        }

        return 0;
    }
}
