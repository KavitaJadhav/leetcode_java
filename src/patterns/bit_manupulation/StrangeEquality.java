//https://www.scaler.com/academy/mentee-dashboard/class/514022/homework/problems/936/?navref=cl_pb_nv_tb
package patterns.bit_manupulation;
//Given an integer A.
//Two numbers, X and Y, are defined as follows:
//
//X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
//Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
//Find and return the XOR of X and Y.

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

//101
//010
//111
//101
//1000
//1101