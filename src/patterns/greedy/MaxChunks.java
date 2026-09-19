//https://www.scaler.com/academy/mentee-dashboard/class/514032/homework/problems/4036/submissions
 package patterns.greedy;
//array is a permutation of numbers from 0 to N - 1.
//So number present at the same index are can divide values in junk, if larger number present before its index then it won't be diving junk from current index
import java.util.*;
public class MaxChunks {
    public int solve(ArrayList<Integer> input) {
        int max = 0;
        int chunks = 0;

        for (int index = 0; index < input.size(); index++) {
            max = Math.max(max, input.get(index));

            if (max == index) {
                chunks++;
            }
        }

        return chunks;
    }
}
