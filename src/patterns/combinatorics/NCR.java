//https://www.scaler.com/academy/mentee-dashboard/class/514029/assignment/problems/4111?navref=cl_tt_lst_sl
 package patterns.combinatorics;

//Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
// x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

public class NCR {

    public int solve(int n, int r, int m) {
        int[] dp = new int[n+1];

        dp[0]=1%m;
        for(int iIndex= 1; iIndex<=n; iIndex++){
            for(int jIndex = Math.min(iIndex, r); jIndex >=1; jIndex--){
                dp[jIndex] = ((dp[jIndex]%m)+(dp[jIndex-1]%m))%m;
            }
        }

        return dp[r];
    }
}

