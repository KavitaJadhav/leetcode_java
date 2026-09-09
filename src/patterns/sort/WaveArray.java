//https://www.scaler.com/academy/mentee-dashboard/class/514033/homework/problems/267/?navref=cl_pb_nv_tb
 package patterns.sort;

import java.util.*;

public class WaveArray {

    public ArrayList<Integer> wave(ArrayList<Integer> values) {
        if (values.size() <= 1)
            return values;

        Collections.sort(values);

        for (int index = 1; index < values.size(); index += 2) {
            swap(values, index, index - 1);
        }
        return values;
    }

    private void swap(ArrayList<Integer> values, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }

}
