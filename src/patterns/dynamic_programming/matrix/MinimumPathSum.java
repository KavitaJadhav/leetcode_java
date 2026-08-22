package patterns.dynamic_programming.matrix;

import java.util.*;

public class MinimumPathSum {

    public int minPathSum(ArrayList<ArrayList<Integer>> grid) {
        int rows = grid.size();
        if (rows == 0)
            return 0;
        int columns = grid.get(0).size();

        int[][] dp = new int[rows][columns];

        dp[0][0] = grid.get(0).get(0);

        for (int column = 1; column < columns; column++) {
            dp[0][column] = dp[0][column - 1] + grid.get(0).get(column);
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid.get(row).get(0);
        }

        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1]) + grid.get(row).get(column);
            }

        }
        return dp[rows - 1][columns - 1];


    }
}
