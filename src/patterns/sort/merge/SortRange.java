//https://www.scaler.com/academy/mentee-dashboard/class/514032/homework/problems/88770/submissions
//Todo: Solve again
package patterns.sort.merge;

import java.util.ArrayList;

public class SortRange {

    public ArrayList<Integer> sortSubarray(ArrayList<Integer> input, int startIndex, int endIndex) {
        sort(input, startIndex, endIndex);
        return input;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> input, int startIndex, int endIndex) {

        if (startIndex >= endIndex)
            return input;
        int mid = startIndex + (endIndex - startIndex) / 2;


        sort(input, startIndex, mid);
        sort(input, mid + 1, endIndex);
        merge(input, startIndex, mid, endIndex);
        return input;
    }

    public void merge(ArrayList<Integer> input, int startIndex, int midIndex, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (input.get(leftIndex) > input.get(rightIndex)) {
                result.add(input.get(rightIndex));
                rightIndex++;
            } else {
                result.add(input.get(leftIndex));
                leftIndex++;
            }
        }

        while (rightIndex <= endIndex) {
            result.add(input.get(rightIndex));
            rightIndex++;
        }

        while (leftIndex <= midIndex) {
            result.add(input.get(leftIndex));
            leftIndex++;
        }

        for (int index = 0; index < result.size(); index++) {
            input.set(startIndex, result.get(index));
            startIndex++;
        }
    }
}
