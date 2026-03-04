//⏱ Complexity
//
//Let:
//
//M = rows
//
//N = cols
//
//Time:
//O(M × N)
//
//Each cell visited at most once per ocean.
//
//Space:
//O(M × N)
//
//For recursion stack + sets.

package graph;

import java.util.*;

public class PacificAtlanticWater {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        Set<List<Integer>> pacific = new HashSet<List<Integer>>();
        Set<List<Integer>> atlantic = new HashSet<List<Integer>>();

        //Todo: move, rows, column, height to constructor. to be available from all methods
        int rows = heights.length;
        int columns = heights[0].length;

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, heights[row][0], pacific);
            dfs(heights, row, columns - 1, heights[row][columns - 1], atlantic);
        }

        for (int col = 0; col < columns; col++) {
            dfs(heights, 0, col, heights[0][col], pacific);
            dfs(heights, rows - 1, col, heights[rows - 1][col], atlantic);
        }
        pacific.retainAll(atlantic);
        return new ArrayList<>(pacific);
    }

    public void dfs(int[][] heights, int row_index, int col_index, int previous_height, Set<List<Integer>> ocean) {
        int rows = heights.length;
        int columns = heights[0].length;

        if (row_index < 0 || row_index >= rows || col_index < 0 || col_index >= columns) return;

        if (ocean.contains(new ArrayList<>(Arrays.asList(row_index, col_index)))) return;
        if (heights[row_index][col_index] < previous_height) return;

        ocean.add(new ArrayList<>(Arrays.asList(row_index, col_index)));
        dfs(heights, row_index + 1, col_index, heights[row_index][col_index], ocean);
        dfs(heights, row_index - 1, col_index, heights[row_index][col_index], ocean);
        dfs(heights, row_index, col_index + 1, heights[row_index][col_index], ocean);
        dfs(heights, row_index, col_index - 1, heights[row_index][col_index], ocean);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        PacificAtlanticWater pacificAtlanticWater = new PacificAtlanticWater();
        System.out.println(pacificAtlanticWater.pacificAtlantic(grid));

    }
}
