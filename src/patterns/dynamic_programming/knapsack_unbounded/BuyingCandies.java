//https://www.scaler.com/academy/mentee-dashboard/class/514053/homework/problems/9011/submissions
package patterns.dynamic_programming.knapsack_unbounded;

import java.util.ArrayList;

public class BuyingCandies {

    public int solve(ArrayList<Integer> candies, ArrayList<Integer> sweetness, ArrayList<Integer> costs, int targetCost) {
        if(candies.size()==0 || targetCost==0)
            return 0;
        int[] dp = new int[targetCost+1];
        dp[0]=0;

        for(int dpIndex = 1; dpIndex<=targetCost; dpIndex++){
            for(int index = 0; index<costs.size(); index++){
                int cost = costs.get(index);
                int candy = candies.get(index);

                if(cost<= dpIndex)
                {
                    int totalSweetness = (candy*sweetness.get(index)) + dp[dpIndex-cost];
                    dp[dpIndex] = Math.max(dp[dpIndex], totalSweetness);
                }
            }
            // System.out.print(" "+ dp[dpIndex]);
        }
        return dp[targetCost];
    }
}
// unbounded knapsack
//  A-candies = [1, 2, 3]
//  B-sweetness = [2, 2, 10] - this is sweetness per candy
//  C-costs = [2, 3, 9]
//  D = 8
// dp - targetCost
// 0,1,2,3,4,5,6,7,8
// 0,0,2,4,4,6,8,8,10