//https://www.scaler.com/academy/mentee-dashboard/class/514027/assignment/problems/71/submissions
 package patterns.arrays;

import java.util.ArrayList;

public class NextPermutation {

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> numbers) {
        int pivotIndex = -1;

        for (int index = numbers.size() - 2; index >= 0; index--) {
            if (numbers.get(index) < numbers.get(index + 1)) {
                pivotIndex = index;
                break;
            }
        }
        if (pivotIndex == -1) {
            reverse(numbers, 0, numbers.size() - 1);
            return numbers;
        }

        int swapIndex = numbers.size() - 1;

        while (numbers.get(swapIndex) <= numbers.get(pivotIndex)) {
            swapIndex--;

            swap(numbers, pivotIndex, swapIndex);

            int left = pivotIndex + 1;
            int right = numbers.size() - 1;
            reverse(numbers, left, right);
        }
        return numbers;
    }

    private void swap(ArrayList<Integer> numbers, int fromIndex, int toIndex) {
        int temp = numbers.get(fromIndex);
        numbers.set(fromIndex, numbers.get(toIndex));
        numbers.set(toIndex, temp);

    }

    private void reverse(ArrayList<Integer> numbers, int left, int right) {

        while (left < right) {
            swap(numbers, left, right);
            left++;
            right--;
        }

    }
}

