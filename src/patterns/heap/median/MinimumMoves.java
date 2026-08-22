package patterns.heap.median;
import java.util.*;

public class MinimumMoves {

    public int seats(String input) {
        List<Integer> currentSeats = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == 'x') {
                // System.out.print(" "+ index);
                currentSeats.add(index);
            }
        }
        if (currentSeats.size() == 0)
            return 0;
        List<Integer> difference = new ArrayList<>();
        int start = 0;
        for (int index = 0; index < currentSeats.size(); index++) {
            difference.add(currentSeats.get(index) - start);
            start++;
        }

        int median = difference.get(difference.size() / 2);
        int result = 0;
        int mod = 10000003;

        for (int index = 0; index < difference.size(); index++) {
            result += Math.abs(difference.get(index) - median);
            result %= mod;
        }
        result %= mod;
        return result;
    }
}
