package patterns.dynamic_programming.prefix_best;

import java.util.ArrayList;

public class MaximumSum {

    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        if(A.size()==0)
            return 0;

        int dp1 = Integer.MIN_VALUE;
        int dp2 = Integer.MIN_VALUE;
        int dp3 = Integer.MIN_VALUE;

        for(int index= 0; index<A.size(); index++){
            int value = A.get(index);

            dp1 = Math.max(dp1, value*B);
            dp2 = Math.max(dp2, dp1+ (value*C));
            dp3 = Math.max(dp3, dp2+ (value*D));
        }
        return dp3;
    }
}

