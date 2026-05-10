//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/1988505484/
//| Component       | Complexity |
//| --------------- | ---------- |
//| Time            | `O(m × n)` |
//| Space (DP)      | `O(m × n)` |
//| Recursion Stack | `O(m × n)` |

package patterns.graph;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int longestIncreasingPath = 0;

        int[][] longestPath = new int[rows][columns];

        for (int iIndex = 0; iIndex < rows; iIndex++) {
            for (int jIndex = 0; jIndex < columns; jIndex++) {
                longestIncreasingPath = Math.max(
                        dfs(longestPath, matrix, iIndex, jIndex),
                        longestIncreasingPath
                );
            }
        }
        return longestIncreasingPath;
    }

    private int dfs(int[][] longestPath, int[][] matrix,
                    int iIndex, int jIndex) {

        if (longestPath[iIndex][jIndex] != 0)
            return longestPath[iIndex][jIndex];

        int rows = matrix.length;
        int columns = matrix[0].length;

        int longest = 1;

        int[][] directions = {
                {1, 0},   // down
                {-1, 0},  // up
                {0, 1},   // right
                {0, -1}   // left
        };

        for (int[] dir : directions) {
            int newI = iIndex + dir[0];
            int newJ = jIndex + dir[1];

            if (newI >= 0 && newI < rows &&
                    newJ >= 0 && newJ < columns &&
                    matrix[newI][newJ] > matrix[iIndex][jIndex]) {

                longest = Math.max(longest,
                        1 + dfs(longestPath, matrix, newI, newJ));
            }
        }

        longestPath[iIndex][jIndex] = longest;
        return longest;
    }
}