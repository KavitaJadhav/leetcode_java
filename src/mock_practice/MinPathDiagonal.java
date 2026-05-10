//https://leetcode.com/problems/minimum-path-sum/description/
//extension

package mock_practice;

//Given a matrix grid[m][n], start from (0,0) and reach (m-1,n-1)
//Allowed moves:
//
//Right → (i, j+1)
//Down → (i+1, j)
//Diagonal → (i+1, j+1)
//
//        👉 Find the minimum path sum (shortest path)
//
public class MinPathDiagonal {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // start
        dp[0][0] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // fill rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                        dp[i - 1][j - 1]
                );
            }
        }

        return dp[m - 1][n - 1];
    }
}