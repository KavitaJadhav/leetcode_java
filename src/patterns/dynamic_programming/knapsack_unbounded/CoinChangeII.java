//https://leetcode.com/problems/coin-change-ii/
//https://www.scaler.com/academy/mentee-dashboard/class/514056/assignment/problems/319/?navref=cl_pb_nv_tb

//Loop order matters.
//Correct:
//for(coin)
//for(amount)
//If you reverse them, you count permutations instead of combinations.

//This problem is a classic unbounded knapsack DP pattern.
//Similar problems:
//Coin Change II
//Combination Sum IV
//Perfect Squares
//All use almost the same DP idea.

//| Metric | Value             |
//| ------ | ----------------- |
//| Time   | O(coins × amount) |
//| Space  | O(amount)         |

// Approach - loop through coins. each time sum current combination + combination of reminder after using coin
//Example Walkthrough
//coins = [1,2,5]
//amount = 5

//Initial:
//dp = [1,0,0,0,0,0]
//After coin 1:
//[1,1,1,1,1,1]
//After coin 2:
//[1,1,2,2,3,3]
//After coin 5:
//[1,1,2,2,3,4]

//Result:
//dp[5] = 4

 package patterns.dynamic_programming.knapsack_unbounded;


public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] result = new int[amount+1];
        result[0]=1;
        for(int coin:coins){
            for(int index=coin; index<=amount; index++){
                result[index] += result[index-coin];
            }
        }

        return result[amount];
    }
}
// Unbounded Knapsack / Combination DP pattern.
//public class Solution {
//public int coinchange2(ArrayList<Integer> coins, int target) {
//    if(coins.isEmpty()||target==0)
//        return 1;
//    int[] dp = new int[target+1];
//    int mod = 1000007;
//    dp[0] = 1;
//
//    for(int coinIndex = 0; coinIndex< coins.size(); coinIndex++){
//        int coinValue = coins.get(coinIndex);
//        for(int dpIndex = coinValue; dpIndex <=target; dpIndex++){
//            dp[dpIndex] = dp[dpIndex]+ dp[dpIndex-coinValue];
//            dp[dpIndex]%=mod;
//        }
//    }
//    return dp[target];
//}
//}

// unbounded knapsack
//  A = [1, 2, 3]
//  B = 4
// 1,1,1,1
// 1,1,2
// 2,2
// 3,1

// dp - target- 4
// 0,1,2,3,4
// 1,1,1,1,1
// 1,1,2,2,3
// 1,1,2,3,4