//Variant 2: Row-wise & Column-wise Sorted (LeetCode 240 style)
//
//👉 Rows sorted
//👉 Columns sorted
//
//Example:
//
//        1  4  7  11
//        2  5  8  12
//        3  6  9  16
//        10 13 14 17
//
//Idea
//Start from top-right
//If target < current → move LEFT
//If target > current → move DOWN
//Complexity
//Time: O(m + n)
//Space: O(1)

package mock_practice;
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (value == target) return true;
            else if (value > target) col--;   // move left
            else row++;                       // move down
        }

        return false;
    }
}