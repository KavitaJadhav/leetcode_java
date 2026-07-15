//https://leetcode.com/problems/search-a-2d-matrix/
//Todo: change sequence
//Variant 1: Fully Sorted Matrix (LeetCode 74 style)
//
//👉 Each row sorted
//👉 First element of each row > last element of previous row
//
//Example:
//
//        1  3  5  7
//        10 11 16 20
//        23 30 34 60

//Best Approach: Binary Search (Treat as 1D)
//💡 Idea
//Matrix behaves like a sorted array
//
//Convert index:
//
//row = mid / cols
//        col = mid % cols

//Complexity
//Time: O(log(m * n))
//Space: O(1)
package mock_practice;

class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int value = matrix[mid / n][mid % n];

            if (value == target) return true;
            else if (value < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}