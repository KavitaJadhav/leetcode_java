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
class ReferenceDP {
    public int shortestPath(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        for (int j = 0; j <= n; j++) dp[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n] - 1; // steps count
    }
}

//https://leetcode.com/problems/minimum-path-sum/description/
class MatrixShortPathDP {public int minPathSum(int[][] grid) {
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
}}
class MatrixShortPathBFS {
    public int shortestPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int steps = 0;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                if (x == m-1 && y == n-1) return steps;

                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n
                            && !visited[nx][ny] && grid[nx][ny] == 0) {

                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            steps++;
        }

        return -1; // no path
    }
}