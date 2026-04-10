//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |
//

//Approach - start from the beginning of the array
// Compare left and right and move left when left is bigger

package patterns.two_pointers;

class BuyAndSellStockI {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int left = 0;
        int maxProfit = 0;

        for (int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
        }
        return maxProfit;
    }
}