//https://www.scaler.com/academy/mentee-dashboard/class/514025/homework/problems/4105/submissions
package patterns.bit_manupulation;

public class NthMagicNumber {
    public int solve(int A) {
        int result = 0;
        for(int counter = 1 ; counter <= A; counter++){
            int next = 0;
            for(int index = 0; index < 32 ; index++){
                int bit = (counter >> index) & 1;
                if(bit==1){
                    // System.out.print(bit + " ");

                    next+= Math.pow(5, index+1);
                }
            }
            result=next;
            // System.out.print(result + " ");
        }
        return result;
    }
}

