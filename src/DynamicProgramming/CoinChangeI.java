//https://leetcode.com/problems/coin-change/description/


//Important Trick
//We initialize with:
//amount + 1
//because the worst case number of coins cannot exceed amount.

//This problem is a classic unbounded knapsack DP pattern.
//Similar problems:
//Coin Change II
//Combination Sum IV
//Perfect Squares
//All use almost the same DP idea.

//| Metric | Value             |
//| ------ | ----------------- |
//| Time   | O(amount × coins) |
//| Space  | O(amount)         |

 package DynamicProgramming;
import java.util.*;
public class CoinChangeI {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        Arrays.fill(minCoins, amount+1);

        minCoins[0]=0;
        for(int index=1; index<=amount; index++){
            for(int coin:coins){
                if(coin <= index)
                    minCoins[index] = Math.min(minCoins[index], 1 + minCoins[index-coin]);
            }
        }

        if(minCoins[amount] <= amount)
            return minCoins[amount] ;
        else
            return -1;
    }
}