//https://www.scaler.com/academy/mentee-dashboard/class/514033/assignment/problems/88621/submissions
package patterns.sort.quicksort;

import java.util.*;

public class PartitionIndex {

    public int partition(ArrayList<Integer> values) {
        return pivot(values);
    }

    private int pivot(ArrayList<Integer> values) {
        int startIndex = 0;
        int endIndex = values.size() - 1;
        int swapIndex = startIndex;

        for (int index = startIndex; index < endIndex; index++) {
            if (values.get(index) < values.get(endIndex)) {
                swap(values, index, swapIndex);
                swapIndex++;
            }
        }
        swap(values, swapIndex, endIndex);

        return swapIndex;
    }

    private void swap(ArrayList<Integer> values, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }
}
