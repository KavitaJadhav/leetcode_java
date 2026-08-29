//https://www.scaler.com/academy/mentee-dashboard/class/514032/homework/problems/4036/submissions
 package patterns.greedy;
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
