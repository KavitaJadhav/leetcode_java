//https://www.scaler.com/academy/mentee-dashboard/class/514027/homework/problems/63/submissions
// Todo: try another solution
package patterns.arrays;

import java.util.ArrayList;
public class SpiralMatrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(size <= 0)
            return result;

        int[][] array = new int[size][size];

        int row = 0;
        int column = 0;
        int counter = 1;
        int moves = size - 1;
        array[0][0]=1;
        while(moves > 0) {

            // Right
            for(int times = 0; times < moves; times++) {
                array[row][column] = counter++;
                column++;
            }

            // Down
            for(int times = 0; times < moves; times++) {
                array[row][column] = counter++;
                row++;
            }

            // Left
            for(int times = 0; times < moves; times++) {
                array[row][column] = counter++;
                column--;
            }

            // Up
            for(int times = 0; times < moves; times++) {
                array[row][column] = counter++;
                row--;
            }

            // Move to the next inner layer
            row++;
            column++;
            moves -= 2;
        }
        if(size % 2 == 1)
            array[size / 2][size / 2] = counter;

        // Convert to ArrayList<ArrayList<Integer>>
        for(int[] list : array) {
            ArrayList<Integer> currentRow = new ArrayList<>();

            for(int value : list) {
                currentRow.add(value);
            }

            result.add(currentRow);
        }

        return result;
    }
}