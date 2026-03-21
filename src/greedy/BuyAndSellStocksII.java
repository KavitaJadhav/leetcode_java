//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//Complexity
//Time Complexity: O(n)
//Space Complexity: O(1)
//This is the most optimal solution.

package greedy;

class BuyAndSellStocksII {
    public int maxProfit(int[] prices) {

        //        if(prices.length <=1) return 0; Not needed as loop is taking care of it.
        int profit = 0;

        for(int index = 1; index < prices.length; index++){
            profit += Math.max(0, prices[index] - prices[index-1]);
        }

        return profit;
    }
}