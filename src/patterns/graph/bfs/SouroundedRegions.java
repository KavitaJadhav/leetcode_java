//https://www.scaler.com/academy/mentee-dashboard/class/514060/homework/problems/208/submissions
 package patterns.graph.bfs;

import java.util.*;

public class SouroundedRegions {
    class Cell {
        public int row;
        public int column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void solve(ArrayList<ArrayList<Character>> board) {
        int rows = board.size();
        if (rows <= 2)
            return;

        int columns = board.get(0).size();
        if (columns <= 2)
            return;

        boolean[][] safe = new boolean[rows][columns];
        Queue<Cell> queue = new LinkedList<>();

        for (int column = 0; column < columns; column++) {
            if (board.get(0).get(column) == 'O') {
                safe[0][column] = true;
                queue.add(new Cell(0, column));

            }
            if (board.get(rows - 1).get(column) == 'O') {
                safe[rows - 1][column] = true;
                queue.add(new Cell(rows - 1, column));
            }
        }


        for (int row = 0; row < rows; row++) {
            if (board.get(row).get(0) == 'O') {
                safe[row][0] = true;
                queue.add(new Cell(row, 0));
            }

            if (board.get(row).get(columns - 1) == 'O') {
                safe[row][columns - 1] = true;
                queue.add(new Cell(row, columns - 1));
            }
        }

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            int[][] neighbours = {{-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };

            for (int[] neighbour : neighbours) {
                int newRow = cell.row + neighbour[0];
                int newColumn = cell.column + neighbour[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
                    if (board.get(newRow).get(newColumn) == 'O' && !safe[newRow][newColumn]) {
                        queue.offer(new Cell(newRow, newColumn));
                        safe[newRow][newColumn] = true;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board.get(row).get(column) == 'O' && !safe[row][column])
                    board.get(row).set(column, 'X');
            }
        }

    }
}
