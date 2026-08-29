//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/4702/submissions

package patterns.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NoOfIslandsDiagonal {
    class Node {
        public int row;
        public int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();

        if (rows == 0)
            return 0;

        int columns = matrix.get(0).size();

        int result = 0;
        boolean[][] visited = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (matrix.get(row).get(column) == 1 && !visited[row][column]) {
                    bfs(matrix, visited, row, column);
                    result++;
                }
            }
        }
        return result;

    }

    private void bfs(ArrayList<ArrayList<Integer>> matrix, boolean[][] visited, int row, int column) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row, column));
        visited[row][column] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();


            int[][] neighbours = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

            for (int[] n : neighbours) {
                int nextRow = node.row + n[0];
                int nextColumn = node.column + n[1];
                if (nextRow >= 0 && nextRow < rows && nextColumn >= 0 && nextColumn < columns &&
                        !visited[nextRow][nextColumn] &&
                        matrix.get(nextRow).get(nextColumn) == 1) {

                    queue.offer(new Node(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;

                }
            }
        }

    }
}