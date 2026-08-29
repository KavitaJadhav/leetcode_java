package patterns.bit_manupulation;

//https://www.scaler.com/academy/mentee-dashboard/class/514022/assignment/problems/169289/?navref=cl_pb_nv_tb
import java.util.ArrayList;

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
