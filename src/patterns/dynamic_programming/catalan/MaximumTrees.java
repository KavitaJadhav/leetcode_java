package patterns.dynamic_programming.catalan;
//Todo: Implement again.. Forgot the approach
public class MaximumTrees
{
    private int numTrees(int N) {
        int mod = 1000000007;

        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= N; nodes++) {
            for (int root = 1; root <= nodes; root++) {

                dp[nodes] += dp[root - 1] * dp[nodes - root];
                dp[nodes] %= mod;
            }
        }

        return (int) dp[N];
    }}

