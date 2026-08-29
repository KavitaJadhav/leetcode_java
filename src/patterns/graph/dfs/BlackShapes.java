//https://www.scaler.com/academy/mentee-dashboard/class/514060/homework/problems/291/submissions
package patterns.graph.dfs;
import  java.util.*;
public class BlackShapes {


    public int black(ArrayList<String> matrix) {

        int count = 0;

        int rows = matrix.size();

        if(rows == 0)
            return 0;

        int columns = matrix.get(0).length();

        for(int row = 0; row < rows; row++) {

            for(int column = 0; column < columns; column++) {

                if(matrix.get(row).charAt(column) == 'X') {

                    dfs(matrix, row, column);

                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(ArrayList<String> matrix, int row, int column) {

        int rows = matrix.size();
        int columns = matrix.get(0).length();

        if(row < 0 || row >= rows ||
                column < 0 || column >= columns)
            return;

        if(matrix.get(row).charAt(column) != 'X')
            return;

        StringBuilder builder =
                new StringBuilder(matrix.get(row));

        builder.setCharAt(column, '0');

        matrix.set(row, builder.toString());

        int[][] neighbours = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for(int[] neighbour : neighbours) {

            int newRow = row + neighbour[0];
            int newColumn = column + neighbour[1];

            dfs(matrix, newRow, newColumn);
        }
    }
}