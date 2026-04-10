//https://leetcode.com/problems/n-queens/

//| Aspect               | Complexity                                                    |
//| -------------------- | ------------------------------------------------------------- |
//| Time (worst-case)    | O(n!) + O(S × n²)                                             |
//| Space (board + sets) | O(n²)                                                         |
//| Recursion patterns.stack      | O(n)                                                          |
//| Practical note       | Pruning with columns + diagonals reduces actual runtime a lot |

//O(S × n²) - Adding the snapshot
//O(n!) - row column traverse
//Row 1: n options
//Row 2: n-1 options (cannot use same column)
//Row 3: n-2 options

package patterns.backtrack;

import java.util.*;

public class NQueens {

    private void backtrack(int row, char[][] board, Set<Integer> visitedColumns, Set<Integer> positiveD, Set<Integer> negativeD, List<List<String>> result) {
        int columns = board.length;

        if (row == columns) {
            List<String> snapshot = new ArrayList<>();
            for (int index = 0; index < columns; index++) {
                snapshot.add(new String(board[index]));
            }
            result.add(snapshot);
            return;
        }

        for (int column = 0; column < columns; column++) {
            if (visitedColumns.contains(column)) continue;
            if (positiveD.contains(row + column)) continue;
            if (negativeD.contains(row - column)) continue;

            board[row][column] = 'Q';
            visitedColumns.add(column);
            positiveD.add(row + column);
            negativeD.add(row - column);

            backtrack(row + 1, board, visitedColumns, positiveD, negativeD, result);
            board[row][column] = '.';
            visitedColumns.remove(column);
            positiveD.remove(row + column);
            negativeD.remove(row - column);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int index = 0; index < n; index++) {
            Arrays.fill(board[index], '.');
        }

        Set<Integer> visitedColumns = new HashSet<>();
        Set<Integer> positiveD = new HashSet<>();
        Set<Integer> negativeD = new HashSet<>();

        backtrack(0, board, visitedColumns, positiveD, negativeD, result);
        return result;
    }
}