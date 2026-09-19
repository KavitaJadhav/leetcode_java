//https://www.scaler.com/academy/mentee-dashboard/class/514062/assignment/problems/282?navref=cl_tt_nv
//An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
//
//Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
//
//In one jump a person can move to the adjacent seat (if available).
//
//A = "....x..xx...x.."
//ANS=5
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
