package patterns.dynamic_programming.knapsack_0_1;

import java.util.ArrayList;

public class MaximumCapacity1D {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[] dp = new int[C + 1];

        for (int i = 0; i < A.size(); i++) {
            int value = A.get(i);
            int weight = B.get(i);

            // 0/1 Knapsack -> go backwards
            for (int capacity = C; capacity >= weight; capacity--) {
                dp[capacity] = Math.max(
                        dp[capacity],
                        dp[capacity - weight] + value
                );
            }
        }

        return dp[C];
    }
}