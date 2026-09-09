//https://www.scaler.com/academy/mentee-dashboard/class/514033/assignment/problems/66911/submissions
package patterns.sort.quicksort;

import java.lang.reflect.Array;
import java.util.*;

public class QuickSort {

    public ArrayList<Integer> solve(ArrayList<Integer> values) {
        int startIndex = 0;
        int endIndex = values.size() - 1;
        return sort(values, startIndex, endIndex);
    }

    private ArrayList<Integer> sort(ArrayList<Integer> values, int startIndex, int endIndex) {

        if (startIndex >= endIndex)
            return values;

        int pivotIndex = pivot(values, startIndex, endIndex);

        if (pivotIndex > startIndex)
            sort(values, startIndex, pivotIndex - 1);

        if (pivotIndex < endIndex)
            sort(values, pivotIndex + 1, endIndex);
        return values;
    }

    private int pivot(ArrayList<Integer> values, int startIndex, int endIndex) {

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

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(
                quickSort.solve(new ArrayList<>(Arrays.asList(1, 4, 2, 1)))
        );
    }
}
