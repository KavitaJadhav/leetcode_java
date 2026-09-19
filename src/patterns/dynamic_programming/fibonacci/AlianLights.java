//https://www.scaler.com/academy/mentee-dashboard/class/514053/homework/problems/4806/?navref=cl_pb_nv_tb
//You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.
    //Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.
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
//AT each step I have two choices, set to 0 or 1(off/on)
//if previous signal is 0 then I can take all values and continue
//if previous signal is 1 then I can't take all values, innstaed I can take all values from 2nd last

//0,1,2,3
//n,0,0,0
//n,1,1,1

//for 2
//all previous signals
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