package patterns.bit_manupulation;

//https://www.scaler.com/academy/mentee-dashboard/class/514022/assignment/problems/169289/?navref=cl_pb_nv_tb
import java.util.ArrayList;
//You are given a binary array A of length N where each element is either 0 or 1.
//Your task is to count the number of subarrays where the bitwise OR of all the elements in the subarray is 1.

public class SubArrayOr1 {
    public int subarraysWithOR1(ArrayList<Integer> input) {
        int elements = input.size();
        int totalSubArrays = elements * (elements + 1) / 2;

        int consucativeZeros = 0;
        for (int index = 0; index < input.size(); index++) {
            if (input.get(index) == 0) {
                consucativeZeros++;
            } else {
                totalSubArrays -= consucativeZeros * (consucativeZeros + 1) / 2;
                consucativeZeros = 0;
            }
        }
        totalSubArrays -= consucativeZeros * (consucativeZeros + 1) / 2;
        return totalSubArrays;
    }
}
