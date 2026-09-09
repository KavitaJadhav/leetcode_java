//https://www.scaler.com/academy/mentee-dashboard/class/523678/homework/problems/5153/submissions
package patterns.sliding_window;

import java.util.*;

public class TotalElements {

    public ArrayList<Integer> solve(ArrayList<Integer> values, int operations) {
        Collections.sort(values);

        int element = values.get(0);
        int count = 1;

        int left = 0;
        int right = 1;
        long windowSum = values.get(0);

        while (right < values.size()) {
            int valueAtRight = values.get(right);

            windowSum += valueAtRight;

            int total_elements = right - left + 1;
            long operationsNeeded =
                    (long) total_elements * valueAtRight - windowSum;

            while (operationsNeeded > operations) {
                windowSum -= values.get(left);
                left++;

                total_elements = right - left + 1;
                operationsNeeded =
                        (long) total_elements * valueAtRight - windowSum;
            }

            if (total_elements > count) {
                count = total_elements;
                element = valueAtRight;
            }

            right++;
        }

        return new ArrayList<>(Arrays.asList(count, element));
    }
}
// A = [1, 2, 4, 5, 5, 8]
// B = 5