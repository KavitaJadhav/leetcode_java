package patterns.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixShortPath {
    public int FindShortestPath(ArrayList<ArrayList<Integer>> matrix, int sRow, int sCol, int dRow, int dCol) {
        int  rows  = matrix.size();
        int cols = matrix.get(0).size();

        boolean[][] visted = new boolean[rows][cols];
        // if(B==D && C==E)
        // return 0;

        int minPath = dfs(matrix, visted, sRow, sCol, dRow, dCol);

        if(minPath == Integer.MAX_VALUE)
            return -1;

        return minPath;
    }

    public int dfs(ArrayList<ArrayList<Integer>> matrix, boolean[][] visited, int sRow, int sCol, int dRow, int dCol){
        int  rows  = matrix.size();
        int cols = matrix.get(0).size();

        if(sRow < 0 || sRow >= rows || sCol < 0 || sCol >=cols)
            return Integer.MAX_VALUE;

        if (visited[sRow][sCol])
            return Integer.MAX_VALUE;

        if(matrix.get(sRow).get(sCol)==0)
            return Integer.MAX_VALUE;

        if(sRow==dRow && sCol==dCol)
            return 0;


        visited[sRow][sCol]=true;
        int minPath = Integer.MAX_VALUE;
        minPath = Math.min(minPath, dfs(matrix, visited, sRow+1, sCol, dRow, dCol));
        minPath = Math.min(minPath, dfs(matrix, visited, sRow-1, sCol, dRow, dCol));
        minPath = Math.min(minPath, dfs(matrix, visited, sRow, sCol+1, dRow, dCol));
        minPath = Math.min(minPath, dfs(matrix, visited, sRow, sCol-1, dRow, dCol));
        visited[sRow][sCol]=false;

        if(minPath == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return minPath + 1;
    }

    public static void main(String[] args) {
        MatrixShortPath matrixShortPath = new MatrixShortPath();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        System.out.println(matrixShortPath.FindShortestPath(matrix, 0, 0, 0, 2));
        System.out.println(matrixShortPath.FindShortestPath(matrix, 0, 0, 0, 1));

    }
}
