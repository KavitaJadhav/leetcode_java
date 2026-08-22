//https://www.scaler.com/academy/mentee-dashboard/class/514056/homework/problems/4824?navref=cl_tt_lst_sl
package patterns.dynamic_programming.subsequenses;

//Todo: revisit
import java.util.*;

public class LongestFibonacci {
    public int solve(ArrayList<Integer> nums) {
        int n = nums.size();

        if (n < 3) {
            return 0;
        }

        HashMap<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.put(nums.get(i), i);
        }

        // dp[i][j] = length ending with nums[i], nums[j]
        int[][] dp = new int[n][n];
        int ans = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {

                int prev = nums.get(j) - nums.get(i);

                Integer k = pos.get(prev);

                if (k != null && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2;
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans >= 3 ? ans : 0;
    }
}

//  A = [1, 3, 7, 11, 12, 14, 18]
// dp = [1, 1, 1, 1, ]

