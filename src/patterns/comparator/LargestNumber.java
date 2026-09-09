//https://www.scaler.com/academy/mentee-dashboard/class/514033/assignment/problems/64/?navref=cl_pb_nv_tb

package patterns.comparator;
//Given an array A of non-negative integers, arrange them such that they form the largest number.
import java.util.*;

public class LargestNumber {

    public String largestNumber(ArrayList<Integer> values) {
        if (values.size() == 0)
            return "0";
        ArrayList<String> stringValues = new ArrayList<>();

        for (Integer value : values) {
            stringValues.add(value.toString());
        }
        Collections.sort(stringValues, (a, b) -> {
            String first = a + b;
            String second = b + a;
            return second.compareTo(first);
        });

        if (stringValues.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String value : stringValues) {
            sb.append(value);
        }
        return sb.toString();
    }
}
//A = [3, 30, 34, 5, 9]
//        9534330