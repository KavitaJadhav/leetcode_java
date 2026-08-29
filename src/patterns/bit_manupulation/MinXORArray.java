//https://www.scaler.com/academy/mentee-dashboard/class/514022/homework/problems/383/submissions
package patterns.bit_manupulation;

import java.util.*;

public class MinXORArray {
    public int findMinXor(ArrayList<Integer> input) {
        Collections.sort(input);
        int result = Integer.MAX_VALUE;

        for(int index = 1; index <input.size(); index++){
            result = Math.min(result, input.get(index-1)^input.get(index));
        }

        return result;
    }
}
