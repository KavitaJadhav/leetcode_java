//https://leetcode.com/problems/number-of-islands/
//Time Complexity: O(M × N)
//
//Let M = number of rows, N = number of columns.
//
//We visit every cell at most once.
//
//DFS explores all connected '1' cells for each island, marking them '0'.
//
//Each cell is visited exactly once, so total work is O(M × N).
//
//Space Complexity: O(M × N) in worst case
//
//Recursion patterns.stack: In the worst case, the entire grid is land ('1') → DFS patterns.stack depth can be up to M × N.
//
//        In-place marking: You mark visited cells as '0', so no extra grid needed.
//
//So overall:
//
//Time: O(M × N)
//
//Space: O(M × N) (due to recursion)
//
package patterns.graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;


        for (int i_index = 0; i_index < rows; i_index++) {
            for (int j_index = 0; j_index < columns; j_index++) {
                if (grid[i_index][j_index] == '1') {
                    dfs(grid, i_index, j_index);
                    result++;

                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int row_index, int column_index) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (row_index < 0 || row_index >= rows || column_index < 0 || column_index >= columns) return;

        char char_at_index = grid[row_index][column_index];
        if (char_at_index != '1') return;

        grid[row_index][column_index] = '0';
        dfs(grid, row_index + 1, column_index);
        dfs(grid, row_index - 1, column_index);
        dfs(grid, row_index, column_index + 1);
        dfs(grid, row_index, column_index - 1);
    }


    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
