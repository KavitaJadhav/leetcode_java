//https://www.scaler.com/academy/mentee-dashboard/class/514027/homework/problems/66/submissions
package patterns.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Add1ToDigitsArray {
    public ArrayList<Integer> plusOne(ArrayList<Integer> digits) {
        while (!digits.isEmpty() && digits.get(0) == 0) {
            digits.remove(0);
        }
        if (digits.isEmpty())
            return new ArrayList<>(Arrays.asList(1));


        int index = digits.size() - 1;
        // int remainder = 0;
        int currentSum = 0;
        int carrier = 1;

        while (index >= 0) {
            currentSum = digits.get(index) + carrier;
            digits.set(index, currentSum % 10);
            carrier = currentSum / 10;
            // System.out.print(index + " " + carrier + " " + currentSum + ",");
            if (carrier == 0)
                break;
            index--;
        }


        if (carrier == 1) {
            digits.add(0, carrier);
        }

        return digits;
    }
}
