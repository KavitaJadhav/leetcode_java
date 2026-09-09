//https://www.scaler.com/academy/mentee-dashboard/class/514060/homework/problems/292/?navref=cl_pb_nv_tb
// minimum number of steps for the knight to move from source to destination
//Knight minimum-moves problem, BFS is preferred over Dijkstra.
//The reason is the edge cost.

//BFS vs Dijkstra
//| Situation                                 | Preferred    |
//| ----------------------------------------- | ------------ |
//| Every move costs `1`                      | **BFS**      |
//| Edges have different non-negative costs   | **Dijkstra** |
//| Edges have only `0` or `1` cost           | **0-1 BFS**  |
//| Need shortest path in an unweighted graph | **BFS**      |

package patterns.graph.bfs;

import java.util.*;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
import java.util.*;

public class MoveKnight {

    class Node {
        public int row;
        public int column;
        public int moves;

        public Node(int row, int column, int moves) {
            this.row = row;
            this.column = column;
            this.moves = moves;
        }
    }

    public int knight(int rows, int columns,
                      int sourceRow, int sourceColumn,
                      int targetRow, int targetColumn) {
//input is one indexed
        sourceRow--;
        sourceColumn--;
        targetRow--;
        targetColumn--;

        if (sourceRow == targetRow && sourceColumn == targetColumn)
            return 0;

        if (sourceRow < 0 || sourceRow >= rows ||
                sourceColumn < 0 || sourceColumn >= columns ||
                targetRow < 0 || targetRow >= rows ||
                targetColumn < 0 || targetColumn >= columns)
            return -1;

        int[][] distance = new int[rows][columns];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(sourceRow, sourceColumn, 0));
        distance[sourceRow][sourceColumn] = 0;

        int[][] neighbours = {
                {-2, -1},
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2}
        };

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.row == targetRow && node.column == targetColumn)
                return node.moves;

            for (int[] neighbour : neighbours) {

                int newRow = node.row + neighbour[0];
                int newColumn = node.column + neighbour[1];

                if (newRow >= 0 && newRow < rows &&
                        newColumn >= 0 && newColumn < columns) {

                    int newDistance = node.moves + 1;

                    if (newDistance < distance[newRow][newColumn]) {

                        distance[newRow][newColumn] = newDistance;

                        queue.offer(
                                new Node(newRow, newColumn, newDistance)
                        );
                    }
                }
            }
        }

        return -1;
    }
}