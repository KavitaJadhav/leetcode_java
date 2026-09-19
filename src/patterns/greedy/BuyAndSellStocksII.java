//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//Complexity
//Time Complexity: O(n)
//Space Complexity: O(1)
//This is the most optimal solution.
//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
package patterns.greedy;

class BuyAndSellStocksII {
    public int maxProfit(int[] prices) {

        int profit = 0;

        for(int index = 1; index < prices.length; index++){
            profit += Math.max(0, prices[index] - prices[index-1]);
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellStocksII().maxProfit(new int[]{1,2,1,3}));
//        3
    }
}
