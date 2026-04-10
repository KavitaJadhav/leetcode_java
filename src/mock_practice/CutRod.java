//This is the classic Rod Cutting (Unbounded Knapsack) problem.
//You have:
//A rod of length n
//price[i] → price of rod of length i+1
//        👉 You can cut the rod into pieces
//👉 Goal: maximize total cost
//
//dp[i] = max(price[j] + dp[i - j - 1])
//        for j = 0 → i-1

//Time: O(n²)
//Outer loop → n
//Inner loop → up to n
//Space: O(n)
//DP array
package mock_practice;


class CutRod {
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];

        // dp[i] = max cost for rod length i
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            }

            dp[i] = maxVal;
        }

        return dp[n];
    }
}