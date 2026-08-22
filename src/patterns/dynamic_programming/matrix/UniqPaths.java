package patterns.dynamic_programming.matrix;

import java.util.ArrayList;

public class UniqPaths {

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> grid) {
        int rows = grid.size();
        int columns = grid.get(0).size();

        int[][] dp = new int[rows][columns];
        dp[0][0] = grid.get(0).get(0)==1 ? 0 : 1;

        for(int column = 1; column <columns; column++){
            if(grid.get(0).get(column)==1){
                dp[0][column] = 0;
            }else{
                dp[0][column] = dp[0][column-1];
            }
        }
        for(int row = 1; row <rows; row++){
            if(grid.get(row).get(0)==1){
                dp[row][0] = 0;
            }else{
                dp[row][0] = dp[row-1][0];
            }
        }

        for(int row = 1; row<rows; row++){
            for(int column = 1; column< columns; column++){
                if(grid.get(row).get(column)==1){
                    dp[row][column] = 0;
                }else{
                    dp[row][column] = dp[row-1][column] +  dp[row][column-1] ;
                }
            }
        }
        return dp[rows-1][columns-1];
    }
}
