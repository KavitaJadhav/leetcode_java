//https://www.scaler.com/academy/mentee-dashboard/class/514050/homework/problems/602/?navref=cl_pb_nv_tb
package patterns.binary_search.bsOnAnswer;
import java.util.*;
//what will be the max value in the list after adding an element to rhe original value at the index n times
public class MinimumLargestElement {

    public int solve(ArrayList<Integer> values, int operations) {
        int maxValue=Integer.MIN_VALUE;

        for(int value: values){
            maxValue= Math.max(value, maxValue);
        }

        int min = maxValue;
        int max = maxValue*(operations+1);
        while(min<max){
            int mid = min + (max-min)/2;
            int currentOperations=0;
            for(int value: values){
                currentOperations += (mid/value)-1;
            }
            if(currentOperations >= operations){
                max = mid;
            }else{
                min = mid+1;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumLargestElement().solve(new ArrayList<>(Arrays.asList(1,2,3,4)), 4));
        System.out.println(new MinimumLargestElement().solve(new ArrayList<>(Arrays.asList(1,2,3,4)), 6));
    }

}
//1,2,3,4
//4
//- Ans = 4
//3,4,3,4

//1,2,3,4
//6
//- Ans = 6
//6,4,3,4
//5,4,6,4