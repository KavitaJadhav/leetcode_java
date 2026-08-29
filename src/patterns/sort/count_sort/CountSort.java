//https://www.scaler.com/academy/mentee-dashboard/class/514032/assignment/problems/21391/submissions
package patterns.sort.count_sort;

import java.util.*;

public class CountSort {

    public ArrayList<Integer> solve(ArrayList<Integer> input) {
        if (input.size() <= 1)
            return input;

        int max = Collections.max(input);
        int[] counts = new int[max + 1];

        for (Integer num : input) {
            counts[num]++;
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int index = 0; index <= max; index++) {
            for (int count = 0; count < counts[index]; count++) {
                result.add(index);
            }
        }
        return result;
    }
}

