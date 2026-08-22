//https://www.scaler.com/academy/mentee-dashboard/class/514024/assignment/problems/269?navref=cl_tt_nv
package patterns.maths.other;

public class GCD {

    public int gcd(int num1, int num2) {
        if(num1 < num2)
            return gcd(num2, num1);
        if(num2==0)
            return num1;
        if(num2==1)
            return 1;
        if(num1%num2==0)
            return num2;

        return gcd(num2, num1%num2);
    }
}
