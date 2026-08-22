//https://www.scaler.com/academy/mentee-dashboard/class/514053/homework/problems/4806/?navref=cl_pb_nv_tb
package patterns.dynamic_programming.fibonacci;
//Todo: Understand better
public class AlianLights {
    public int solve(int A) {
        int MOD = 1000000007;

        if (A == 0) return 1;
        if (A == 1) return 2;

        long prev2 = 1; // dp[0]
        long prev1 = 2; // dp[1]

        for (int i = 2; i <= A; i++) {
            long current = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }
}
// House robber pagttern?
// A = 2, 2^A signals
// 00
// 01
// 10
// 11
// result = 3


// A=3
// result1 = "", 0,0,1
// result2 = "", 1,0,1
// count = 2, 4,6
//