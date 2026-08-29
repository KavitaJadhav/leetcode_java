//https://www.scaler.com/academy/mentee-dashboard/class/514025/homework/problems/4531?navref=cl_tt_nv
 package patterns.bit_manupulation;

public class HelpFromSam {
    public int solve(int target) {
        int result = 0;

        while(target!=0){
            // n = n&(n-1);
            target &= (target-1);
            result++;
        }
        return result;
    }
}
