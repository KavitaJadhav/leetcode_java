//https://www.scaler.com/academy/mentee-dashboard/class/514027/assignment/problems/49000?navref=cl_tt_nv
package patterns.arrays;
import java.util.*;
public class SpiralBoundries {

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        ArrayList<Integer> result = new ArrayList<>();

        if(rows==0)
            return result;

        int row = 0;
        int column = 0;
        // result.add(matrix.get(row).get(column));
        while(column <= columns-2){
            result.add(matrix.get(row).get(column));
            column++;
        }

        while(row <= rows-2){
            result.add(matrix.get(row).get(column));
            row++;
        }


        while(column > 0){
            result.add(matrix.get(row).get(column));
            column--;
        }

        while(row > 0){
            result.add(matrix.get(row).get(column));
            row--;
        }

        return result;
    }
}
