//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/11?navref=cl_tt_nv
//Todo: Solve 3 & 4 variation
package patterns.dynamic_programming.linear_dp;

import java.util.List;

public class BuyAndSellStocksII {
public int maxProfit(final List<Integer> prices) {
    if(prices.size()<=1)
        return 0;

    int hold = 0-prices.get(0);
    int cash = 0;

    // System.out.print(hold + " " + cash + ",");

    for(int index = 1; index < prices.size(); index++){
        int currentPrice = prices.get(index);
        int oldhold = hold;
        hold = Math.max(hold, cash-currentPrice);
        cash = Math.max(cash, oldhold+currentPrice);
        // System.out.print(hold + " " + cash + ",");
    }

    return cash;
}
}
