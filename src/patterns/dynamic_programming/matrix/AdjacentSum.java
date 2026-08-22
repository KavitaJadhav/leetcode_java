package patterns.dynamic_programming.matrix;

import java.util.ArrayList;

public class AdjacentSum {
    public int adjacent(ArrayList<ArrayList<Integer>> grid) {
        int columns = grid.get(0).size();

        int[] reduced = new int[columns];

        for(int column=0; column < columns; column++){
            reduced[column] = Math.max(grid.get(0).get(column), grid.get(1).get(column));
        }

        if(columns==1)
            return reduced[0];

        int[] dp = new int[columns];
        dp[0] = reduced[0];
        dp[1] = Math.max(reduced[0], reduced[1]);

        for(int index=2; index < columns; index++){
            dp[index] = Math.max(dp[index-1], reduced[index]+dp[index-2]);
        }
        return dp[columns-1];
    }
}
