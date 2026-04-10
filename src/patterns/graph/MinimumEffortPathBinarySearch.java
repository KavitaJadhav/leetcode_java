//https://leetcode.com/problems/path-with-minimum-effort/

// Approach (2–3 Line Interview Summary)
//Binary search the minimum effort E.
//For each candidate effort, run BFS and only move to neighbors whose height difference ≤ E.
//The smallest E that allows reaching the destination is the answer.

//| Approach             | Time          | Difficulty          |
//| -------------------- | ------------- | ------------------- |
//| Dijkstra             | O(mn log mn)  | ⭐ easiest           |
//| Binary Search + BFS  | O(mn log 1e6) | ⭐⭐                  |
//| Union Find (Kruskal) | O(mn log mn)  | ⭐⭐⭐ Google favorite |

//TODO: IMPLEMENT Union Find (Kruskal)
//3️⃣ Third solution (advanced / impressive)

//Union Find (Kruskal)
//This reframes the problem as:
//Minimum spanning patterns.tree problem.

//Steps:
//Treat each cell as a node.
//Create edges between neighbors with weight = height difference.
//Sort edges.
//Union nodes in increasing order of weight.
//Stop when start and end are connected.

//Time: O(m*n log(m*n))
//When Google Likes Union Find

//Union Find impresses interviewers because it shows you recognize:
//Minimize maximum edge weight
//→ Minimum Spanning Tree
//This is a very strong patterns.graph insight.

package patterns.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumEffortPathBinarySearch {
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
        int left = 0;
        int right = 1000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReach(heights, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canReach(int[][] heights, int maxDiff) {
        int targetRow = heights.length - 1;
        int targetColumn = heights[0].length - 1;

        Queue<Cell> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        queue.add(new Cell(0, 0, heights[0][0], 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            if (cell.row == targetRow && cell.column == targetColumn) {
                return true;
            }

            if (!visited[cell.row][cell.column]) {
                visited[cell.row][cell.column] = true;
                if (cell.row + 1 < heights.length) {
                    int absDiff = Math.abs(heights[cell.row + 1][cell.column] - cell.value);
                    if (absDiff <= maxDiff)
                        queue.offer(new Cell(cell.row + 1, cell.column, heights[cell.row + 1][cell.column], Math.max(cell.effort, absDiff)));
                }

                if (cell.row - 1 >= 0) {
                    int absDiff = Math.abs(heights[cell.row - 1][cell.column] - cell.value);
                    if (absDiff <= maxDiff)
                        queue.offer(new Cell(cell.row - 1, cell.column, heights[cell.row - 1][cell.column], Math.max(cell.effort, absDiff)));
                }

                if (cell.column + 1 < heights[0].length) {
                    int absDiff = Math.abs(heights[cell.row][cell.column + 1] - cell.value);
                    if (absDiff <= maxDiff)
                        queue.offer(new Cell(cell.row, cell.column + 1, heights[cell.row][cell.column + 1], Math.max(cell.effort, absDiff)));
                }

                if (cell.column - 1 >= 0) {
                    int absDiff = Math.abs(heights[cell.row][cell.column - 1] - cell.value);
                    if (absDiff <= maxDiff)
                        queue.offer(new Cell(cell.row, cell.column - 1, heights[cell.row][cell.column - 1], Math.max(cell.effort, absDiff)));
                }
            }
        }

        return false;
    }
}