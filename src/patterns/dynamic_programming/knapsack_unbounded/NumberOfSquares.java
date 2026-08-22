package patterns.dynamic_programming.knapsack_unbounded;

import java.util.Arrays;

public class NumberOfSquares {
    public int countMinSquares(int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, target+1);
        dp[0]=0;
        dp[1] = 1;


        for(int dpValue = 2; dpValue<= target; dpValue++){
            for(int number = 1; number*number <=dpValue; number++){
                dp[dpValue] = Math.min(dp[dpValue], 1 + dp[dpValue-(number*number)]);
            }
            // System.out.print(", "+ dp[dpValue]);
        }

        return dp[target];
    }
}
