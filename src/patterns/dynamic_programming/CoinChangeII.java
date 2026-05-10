//https://leetcode.com/problems/coin-change-ii/


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

 package patterns.dynamic_programming;


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