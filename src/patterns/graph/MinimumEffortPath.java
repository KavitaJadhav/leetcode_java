//https://leetcode.com/problems/path-with-minimum-effort/
// Approach (2–3 Line Interview Summary)

//Treat the grid as a patterns.graph where edge weight is the height difference.
//Use Dijkstra’s algorithm with a min-patterns.heap, where the path cost is the maximum edge weight seen so far.
//Always expand the cell with the minimum effort, and stop when reaching the destination.
//
//Time:  O(m*n log(m*n))
//Space: O(m*n)

package patterns.graph;

import java.util.*;

public class MinimumEffortPath {
    class Cell {
        int row;
        int column;
        int value;
        int effort;

        public Cell(
                int row,
                int column,
                int value,
                int effort) {
            this.row = row;
            this.column = column;
            this.value = value;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int targetRow = heights.length - 1;
        int targetColumn = heights[0].length - 1;

        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        int minEfforts = Integer.MAX_VALUE;
        queue.add(new Cell(0, 0, heights[0][0], 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.row == targetRow && cell.column == targetColumn) {
                return cell.effort;
            }

            if (!visited[cell.row][cell.column]) {
                visited[cell.row][cell.column] = true;
                if (cell.row + 1 < heights.length)
                    queue.offer(new Cell(cell.row + 1, cell.column, heights[cell.row + 1][cell.column], Math.max(cell.effort, Math.abs(heights[cell.row + 1][cell.column] - cell.value))));

                if (cell.row - 1 >= 0)
                    queue.offer(new Cell(cell.row - 1, cell.column, heights[cell.row - 1][cell.column], Math.max(cell.effort, Math.abs(heights[cell.row - 1][cell.column] - cell.value))));

                if (cell.column + 1 < heights[0].length)
                    queue.offer(new Cell(cell.row, cell.column + 1, heights[cell.row][cell.column + 1], Math.max(cell.effort, Math.abs(heights[cell.row][cell.column + 1] - cell.value))));

                if (cell.column - 1 >= 0)
                    queue.offer(new Cell(cell.row, cell.column - 1, heights[cell.row][cell.column - 1], Math.max(cell.effort, Math.abs(heights[cell.row][cell.column - 1] - cell.value))));
            }
        }

        return minEfforts;
    }
}