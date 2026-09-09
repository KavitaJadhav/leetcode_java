//https://www.scaler.com/academy/mentee-dashboard/class/514022/assignment/problems/9412?navref=cl_tt_nv
 package patterns.bit_manupulation;

public class BoomerFood {
    // thoughtprocess-
    // on well behaved day boomer gets food eq = 2^x;
    // no food on other days = 0
    // if behaved well - that signifient bit will be set true else false
    // Exp: day 1 and day 3
    // day 1 = 2^0=1
    // day 3 = 2^2 = 4;
    // total = 5
    // 001+100=101
    // total 2 bits set... each for respective day

    public int solve(int num) {
        int setBits = 0;
        while(num>0){
            int bit = num & 1;
            num>>=1;
            if(bit==1)
                setBits++;
        }
        return setBits;
    }

    public static void main(String[] args) {
        System.out.println(new BoomerFood().solve(10));
//        2
//        10 = 8+0+2+0=2
    }
}
