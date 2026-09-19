//https://www.scaler.com/academy/mentee-dashboard/class/514064/homework/problems/373/submissions
package patterns.dynamic_programming.knapsack_0_1;
//Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
//
//Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
//A = [15, 10, 6]
//1
import java.util.*;

public class FlipValues {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> values) {
        int total = 0;
        for (int value : values) {
            total += value;
        }
        int target = total / 2;

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value : values) {
            for (int dpIndex = target; dpIndex > 0; dpIndex--) {
                if (value <= dpIndex) {
                    int remaing = dpIndex - value;
                    if (dp[remaing] != Integer.MAX_VALUE)
                        dp[dpIndex] = Math.min(dp[dpIndex], 1 + dp[remaing]);
                }
            }
        }

        for (int index = target; index >= 0; index--) {
            if (dp[index] != Integer.MAX_VALUE)
                return dp[index];
        }
        return 0;
    }
}

