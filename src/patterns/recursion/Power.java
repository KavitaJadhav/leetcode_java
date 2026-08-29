//https://www.scaler.com/academy/mentee-dashboard/class/514026/assignment/problems/133460/submissions
 package patterns.recursion;

public class Power {

    public Long power(int number, int power) {
        if(number==1 || power==0)
            return 1l;
        if(power==1)
            return (long)number;

        Long result  = power(number, power/2);
        result*=result;

        if((power%2)==1){
            return result*number;
        }

        return result;
    }
}
