//https://www.scaler.com/academy/mentee-dashboard/class/514056/assignment/problems/9318/?navref=cl_pb_nv_tb
package patterns.dynamic_programming.knapsack_unbounded;

import java.util.ArrayList;

public class CuttingRod {

    public int solve(ArrayList<Integer> prices) {
        // pieces of size 1 to N.
        int target = prices.size();
        if(target==0)
            return 0;

        int[] dp = new int[target+1];
        dp[0]=0;
        for(int dpIndex = 1; dpIndex<=target; dpIndex++){
            for(int priceIndex = 1; priceIndex<= dpIndex; priceIndex++){
                int price = prices.get(priceIndex-1);

                dp[dpIndex] = Math.max(dp[dpIndex], price+dp[dpIndex-priceIndex]);
            }
        }
        return dp[target];
    }
}
//  A = [3, 4, 1, 6, 2]
// dp- 5
// 0,1,2,3,4,5
// 0,1,
