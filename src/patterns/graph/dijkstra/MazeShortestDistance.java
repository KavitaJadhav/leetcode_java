//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/4697/submissions
//https://leetcode.com/problems/the-maze-ii/
//Todo: solve https://leetcode.com/problems/the-maze/description/
package patterns.graph.dijkstra;

//Maze II — Dijkstra + distances[][]
//
//        Let:
//        M = number of rows
//        N = number of columns
//        V = number of vertices / stopping positions
//        E = number of edges
//
//        V = M × N
//
//        Each vertex has at most 4 neighbors.
//
//        However, finding each neighbor requires rolling the ball,
//        which can take O(N) in the worst case.
//
//        Time Complexity:
//        O(V × N × log V)
//
//        Since V = M × N:
//
//        O(M × N² × log(MN))
//
//        Space Complexity:
//        O(V)
//
//        = O(M × N)
//
//        Reason:
//        - distances[][] → O(V)
//        - PriorityQueue → O(V)

import java.util.*;

public class MazeShortestDistance {

    class Node {
        public int row;
        public int column;
        public int distance;

        public Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> maze, ArrayList<Integer> source, ArrayList<Integer> target) {
        int rows = maze.size();
        if (rows == 0)
            return 0;

        int columns = maze.get(0).size();

        int[][] distances = new int[rows][columns];
        for (int index = 0; index < rows; index++) {
            Arrays.fill(distances[index], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        queue.offer(new Node(source.get(0), source.get(1), 0));
        distances[source.get(0)][source.get(1)] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int[][] neighbours = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

            for (int[] n : neighbours) {
                int currentRow = node.row;
                int currentColumn = node.column;
                int count = 0;
                while (currentRow + n[0] >= 0 &&
                        currentRow + n[0] < rows &&
                        currentColumn + n[1] >= 0
                        && currentColumn + n[1] < columns
                        && maze.get(currentRow + n[0]).get(currentColumn + n[1]) != 1) {
                    currentRow += n[0];
                    currentColumn += n[1];
                    count++;
                }

                int newDistance = node.distance + count;
                if (newDistance < distances[currentRow][currentColumn]) {
                    distances[currentRow][currentColumn] = newDistance;
                    queue.offer(new Node(currentRow, currentColumn, newDistance));
                }

            }
        }
        if (distances[target.get(0)][target.get(1)] == Integer.MAX_VALUE)
            return -1;

        return distances[target.get(0)][target.get(1)];
    }
}

//Using visiting set instead of storing all distances
class MazeShortestDistanceAlternative {

    class Node {
        public int row;
        public int column;
        public int distance;

        public Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public int solve(
            ArrayList<ArrayList<Integer>> maze,
            ArrayList<Integer> source,
            ArrayList<Integer> target) {

        int rows = maze.size();

        if (rows == 0) {
            return 0;
        }

        int columns = maze.get(0).size();

        boolean[][] visited = new boolean[rows][columns];

        PriorityQueue<Node> queue =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        queue.offer(new Node(
                source.get(0),
                source.get(1),
                0
        ));

        int[][] neighbours = {
                {0, -1},
                {-1, 0},
                {0, 1},
                {1, 0}
        };

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            // We may have added this stopping point multiple times.
            // Process it only the first time it is removed from the heap.
            if (visited[node.row][node.column]) {
                continue;
            }

            visited[node.row][node.column] = true;

            // Because this is a min-heap, the first time we
            // pop the target, it has the shortest distance.
            if (node.row == target.get(0)
                    && node.column == target.get(1)) {
                return node.distance;
            }

            for (int[] neighbour : neighbours) {

                int currentRow = node.row;
                int currentColumn = node.column;
                int count = 0;

                // Keep rolling until we hit a wall or boundary.
                while (currentRow + neighbour[0] >= 0
                        && currentRow + neighbour[0] < rows
                        && currentColumn + neighbour[1] >= 0
                        && currentColumn + neighbour[1] < columns
                        && maze.get(currentRow + neighbour[0])
                        .get(currentColumn + neighbour[1]) != 1) {

                    currentRow += neighbour[0];
                    currentColumn += neighbour[1];
                    count++;
                }

                // The ball stops at currentRow, currentColumn.
                if (!visited[currentRow][currentColumn]) {
                    queue.offer(new Node(
                            currentRow,
                            currentColumn,
                            node.distance + count
                    ));
                }
            }
        }

        return -1;
    }
}

// A = [ [0, 0],
//       [0, 0] ]
// B = [0, 0]
// C = [0, 1]