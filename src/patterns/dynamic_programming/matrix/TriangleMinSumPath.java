package patterns.dynamic_programming.matrix;
import java.util.ArrayList;

public class TriangleMinSumPath {

    public int minimumTotal(ArrayList<ArrayList<Integer>> grid) {
        int rows = grid.size();

        if(rows==0)
            return 0;

        for(int row = rows-2; row >= 0 ; row--){
            ArrayList<Integer> list =  grid.get(row);

            for(int index = 0; index<list.size(); index++){
                list.set(index, list.get(index) + Math.min(grid.get(row+1).get(index), grid.get(row+1).get(index+1)));
            }
        }

        return grid.get(0).get(0);
    }
}
