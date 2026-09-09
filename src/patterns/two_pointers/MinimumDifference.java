//https://www.scaler.com/academy/mentee-dashboard/class/523682/homework/problems/1104/submissions
package patterns.two_pointers;
import java.util.*;
public class MinimumDifference {

    public int solve(int rows, int columns, ArrayList<ArrayList<Integer>> matrix) {
        int result = Integer.MAX_VALUE;
        for(ArrayList<Integer> row : matrix)
            Collections.sort(row);

        for(int row = 1 ; row <matrix.size(); row++){
            int currentDifference = Integer.MAX_VALUE;
            ArrayList<Integer> currentRow = matrix.get(row);
            ArrayList<Integer> previousRow = matrix.get(row-1);
            int currentIndex = 0;
            int previousIndex = 0;
            while(currentIndex < currentRow.size() && previousIndex < previousRow.size()){
                int difference = Math.abs(currentRow.get(currentIndex) - previousRow.get(previousIndex));
                currentDifference = Math.min(currentDifference, difference);
                if(currentRow.get(currentIndex) < previousRow.get(previousIndex)){
                    currentIndex++;
                }else{
                    previousIndex++;
                }
                result = Math.min(result, currentDifference);
            }
        }

        return result;
    }
}
