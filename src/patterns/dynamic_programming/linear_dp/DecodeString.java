//https://www.scaler.com/academy/mentee-dashboard/class/514064/homework/problems/10/submissions
package patterns.dynamic_programming.linear_dp;

public class DecodeString {
    public int numDecodings(String input) {
        int mod = 1000000007;
        if(input.length() == 0)
            return 0;

        int[] dp = new int[input.length() + 1];

        dp[0] = 1;

        if(input.charAt(0) != '0')
            dp[1] = 1;

        for(int index = 2; index <= input.length(); index++) {

            // One digit
            if(input.charAt(index - 1) != '0') {
                dp[index] = dp[index - 1];
            }

            // Two digits
            int num = (input.charAt(index - 2) - '0') * 10
                    + (input.charAt(index - 1) - '0');

            if(num >= 10 && num <= 26) {
                dp[index] += dp[index - 2];
            }
            dp[index]%=mod;
        }

        return dp[input.length()];
    }
}