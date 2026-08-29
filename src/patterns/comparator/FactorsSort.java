//https://www.scaler.com/academy/mentee-dashboard/class/514033/assignment/problems/27473/submissions
package patterns.comparator;

import java.util.*;

public class FactorsSort {

    public ArrayList<Integer> solve(ArrayList<Integer> values) {
        if (values.size() <= 1)
            return values;
        Collections.sort(values, (a, b) -> {
            int aFactorsCount = factorCount(a);

            int bFactorsCount = factorCount(b);
            if (aFactorsCount == bFactorsCount)
                return Integer.compare(a, b);
            return Integer.compare(aFactorsCount, bFactorsCount);
        });
        return values;
    }

    private int factorCount(int value) {
        int result = 0;
        for (int number = 1; number * number <= value; number++) {
            if (value % number == 0) {
                if (value == number * number)
                    result++;
                else
                    result += 2;
            }
        }
        return result;
    }
}
