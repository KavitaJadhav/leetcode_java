//https://www.scaler.com/academy/mentee-dashboard/class/514060/homework/problems/292/?navref=cl_pb_nv_tb
//Knight minimum-moves problem, BFS is preferred over Dijkstra.
//The reason is the edge cost.

//BFS vs Dijkstra
//| Situation                                 | Preferred    |
//| ----------------------------------------- | ------------ |
//| Every move costs `1`                      | **BFS**      |
//| Edges have different non-negative costs   | **Dijkstra** |
//| Edges have only `0` or `1` cost           | **0-1 BFS**  |
//| Need shortest path in an unweighted graph | **BFS**      |

package patterns.graph.dijkstra;

import java.util.*;

public class MoveKnight {
    class Node{
        public int row;
        public int column;
        public int moves;
        public  Node(int row, int column, int moves){
            this.row = row;
            this.column = column;
            this.moves = moves;
        }
    }
    public int knight(int rows, int columns, int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
        sourceRow--;
        sourceColumn--;
        targetRow--;
        targetColumn--;

        if (sourceRow==targetRow && sourceColumn==targetColumn)
            return 0;
        if(targetRow >=rows && targetColumn >= columns)
            return -1;

        boolean[][] visisted = new boolean[rows][columns];
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a-> a.moves));

        queue.add(new Node(sourceRow, sourceColumn, 0));
        visisted[sourceRow][sourceColumn]=true;

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

        while(!queue.isEmpty()){
            Node node = queue.poll();
            // System.out.print("Helllo");
            if(node.row==targetRow && node.column==targetColumn)
                return node.moves;

            for(int[] neighbour : neighbours) {
                int newRow = node.row + neighbour[0];
                int newColumn = node.column + neighbour[1];

                if(newRow >=0 && newRow < rows && newColumn>=0 && newColumn < columns && !visisted[newRow][newColumn]){
                    queue.offer(new Node(newRow, newColumn, node.moves+1));
                    visisted[newRow][newColumn] = true;
                }
            }
            // visisted[node.row][node.column]=true;
        }

        return -1;
    }
}
