//https://www.scaler.com/academy/mentee-dashboard/class/514022/homework/problems/936/?navref=cl_pb_nv_tb
package patterns.bit_manupulation;

public class StrangeEquality {
    public int solve(int A) {
        int x = 0;
        int highestSetBitIndex = 31 - Integer.numberOfLeadingZeros(A);

        for(int index = 0; index < highestSetBitIndex; index++){
            int bit = (A >> index )&1;
            if(bit==0){
                x|=(1<<index);
            }

        }

        int y = 1 << (highestSetBitIndex+1);

        return x^y;
    }
}
