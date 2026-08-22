//https://www.scaler.com/academy/mentee-dashboard/class/514056/homework/problems/1065/submissions
 package patterns.dynamic_programming.linear_dp;

public class PairingFriends {
    public int solve(int count) {
        if(count<=1)
            return 1;
        int mod = 10003;
        int[] dp = new int[count+1];
        dp[0]=1;
        dp[1]=1;

        for(int index= 2; index<=count; index++){
            dp[index] = dp[index-1] + (dp[index-2] * (index-1));
            dp[index]%=mod;
        }
        return dp[count];
    }
}
// A=3
// 1,2,3
// 12,3
// 13,2
// 1,23

// A = 1
// 1

// A=2
// 1,2
// 12

// A=4
// 1,2,3,4
// 12,3,4
// 13, 2,4
// 1,2,24
// 1,23,4
// 1,2,34
// 14, 2, 3
// 12,34
// 13,24
// 14,23

