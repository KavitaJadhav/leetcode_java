//https://www.scaler.com/academy/mentee-dashboard/class/514072/homework/problems/418/submissions
package patterns.graph.bfs;

import java.util.*;

public class ValidPathWithCircles {
    class Node {
        public int row;
        public int column;

        public Node(int row, int column) {
            this.column = column;
            this.row = row;
        }
    }

    public String solve(int targetRow, int targetColumn, int circles, int radius, ArrayList<Integer> centersX, ArrayList<Integer> centersY) {

        boolean[][] visited = new boolean[targetRow + 1][targetColumn + 1];
        boolean[][] blocked = new boolean[targetRow + 1][targetColumn + 1];

        for (int index = 0; index < circles; index++) {
            // using formula a^2 + b^2 = c^2 to check of point is outside the radis/circle
            if (Math.pow(radius, 2) >= (Math.pow(centersX.get(index) - 0, 2) + Math.pow(centersY.get(index) - 0, 2)))
                return "NO";
            if (Math.pow(radius, 2) >= (Math.pow(centersX.get(index) - targetRow, 2) + Math.pow(centersY.get(index) - targetColumn, 2)))
                return "NO";
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.row == targetRow && node.column == targetColumn)
                return "YES";

            int[][] neighbours = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
            for (int[] n : neighbours) {
                int nextRow = node.row + n[0];
                int nextColumn = node.column + n[1];
                if (nextRow >= 0 && nextRow <= targetRow && nextColumn >= 0 && nextColumn <= targetColumn && !visited[nextRow][nextColumn] && !blocked[nextRow][nextColumn]) {
                    boolean circlePresent = false;

                    for (int index = 0; index < circles; index++) {
                        // using formula a^2 + b^2 = c^2 to check of point is outside the radis/circle
                        if (Math.pow(radius, 2) >= (Math.pow(centersX.get(index) - nextRow, 2) + Math.pow(centersY.get(index) - nextColumn, 2))) {
                            circlePresent = true;
                            blocked[nextRow][nextColumn] = true;

                            break;
                        }
                    }
                    if (!circlePresent) {
                        if (nextRow == targetRow && nextColumn == targetColumn)
                            return "YES";
                        queue.offer(new Node(nextRow, nextColumn));
                        visited[nextRow][nextColumn] = true;
                    }

                }
            }
        }
        return "NO";

    }
}
// Approach
// create integer/boolean array of size m*n
// for each index in the patch check its outside the radius range using formula a^2+b^2 = c^2, C^2 should be grater than radius^2
// bfs remaining path to check if traverse from 0,0 to x,y possible

//So your algorithm should conceptually be:
//1. Is (0,0) blocked?
//YES → NO

//2. Is (x,y) blocked?
//YES → NO

//3. BFS from (0,0)

//4. For each of 8 neighbours:
//outside rectangle → skip
//already visited → skip
//inside any circle → skip
//otherwise → visit + queue

//5. Reach (x,y)?
//YES → YES
//queue empty → NO