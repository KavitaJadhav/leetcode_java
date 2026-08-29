//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/4702/submissions
package patterns.graph.dfs;
import java.util.*;

public class NoOfIslandsDiagonal {

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();

        if (rows == 0)
            return 0;

        int columns = matrix.get(0).size();

        int result = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix.get(row).get(column) == 1) {
                    dfs(matrix, row, column);
                    result++;
                }
            }
        }
        return result;

    }

    private void dfs(ArrayList<ArrayList<Integer>> matrix, int row, int column) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        if (row < 0 || row >= rows || column < 0 || column >= columns)
            return;
        if (matrix.get(row).get(column) == 0)
            return;
        matrix.get(row).set(column, 0);


        int[][] neighbours = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        for (int[] n : neighbours) {
            dfs(matrix, row + n[0], column + n[1]);
        }
    }
}

