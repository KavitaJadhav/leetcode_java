package patterns.dynamic_programming.matrix;
//Given a 2 times N matrix of integers, choose a subset of numbers such that the sum is maximized, under the condition that no two chosen numbers are adjacent vertically, horizontally, or diagonally.

//Compress 2D array to 1D array
//House robber sum on 1D array
import java.util.ArrayList;
import java.util.Arrays;

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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        grid.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));

        System.out.println(new AdjacentSum().adjacent(grid));
    }
}
