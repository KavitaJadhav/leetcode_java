//https://leetcode.com/problems/minimum-path-sum/description/

//shortest path from (0,0) to (m,n) in a matrix/grid
// If unweighted shortest path → ALWAYS think BFS
// If restricted movement (right/down) → think DP
//| Approach        | Time  | Space         |
//| --------------- | ----- | ------------- |
//| DP (right/down) | O(mn) | O(mn) or O(n) |
//| BFS (4-dir)     | O(mn) | O(mn)         |
//| BFS + obstacles | O(mn) | O(mn)         |

//Grid + shortest path + no weights → BFS
//Grid + only right/down → DP
//Grid + weights → Dijkstra
//Grid + constraints → BFS with state

package mock_practice;

class MatrixShortPathDP {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}

class MatrixShortPathBFS {

    static class State {
        int row;
        int col;
        int sum;

        State(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];

        pq.offer(new State(0, 0, grid[0][0]));

        int[][] directions = {{0, 1}, {1, 0}};

        while (!pq.isEmpty()) {

            State current = pq.poll();

            int r = current.row;
            int c = current.col;
            int sum = current.sum;

            // reached destination
            if (r == rows - 1 && c == cols - 1) {
                return sum;
            }

            // stale entry
            if (sum > dist[r][c]) {
                continue;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < rows && nc < cols) {

                    int newSum = sum + grid[nr][nc];

                    if (newSum < dist[nr][nc]) {

                        dist[nr][nc] = newSum;

                        pq.offer(new State(nr, nc, newSum));
                    }
                }
            }
        }

        return -1;
    }
}


//This is DP reference. Solution in MatrixShortPathDP. Todo: move to different file
class ReferenceDP {
    public int shortestPath(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int j = 0; j <= n; j++) dp[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n] - 1; // steps count
    }
}