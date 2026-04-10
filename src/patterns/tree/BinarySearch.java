package patterns.tree;//Note: Works only with Sorted Array
//Spit array in half. Check element is greater than last element of 1st half.
//follow same steps recursively

//Time complexity -
// best - O(1)
// Average - O(log n)
// worst - O(log n)
//package search;

import java.util.Arrays;

public class BinarySearch {
    private int[] right;
    private int[] left;

    private boolean present(int[] list, int number) {
        if (list.length == 0)
            return false;
        if (list.length == 1)
            return list[0] == number;

        int mid = (list.length / 2);

        this.right = Arrays.copyOfRange(list, 0, mid);
        this.left = Arrays.copyOfRange(list, mid + 1, list.length);

        if (number >= left[0])
            return present(left, number);
        else
            return present(right, number);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        System.out.println("Value present : " + binarySearch.present(new int[]{}, 2));
        System.out.println("Value present : " + binarySearch.present(new int[]{2}, 2));
        System.out.println("Value present : " + binarySearch.present(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 2));
        System.out.println("Value present : " + binarySearch.present(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, 20));

    }
}