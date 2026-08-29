//https://www.scaler.com/academy/mentee-dashboard/class/514032/assignment/problems/88764/submissions
 package patterns.sort.count_sort;

import java.util.ArrayList;

public class SmallestNumber {

    public ArrayList<Integer> smallestNumber(ArrayList<Integer> input) {
        int[] freq = new int[10];


        for(Integer num: input){
            freq[num]++;
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int index = 0; index<10; index++){
            for(int count=0; count<freq[index]; count++){
                result.add(index);
            }
        }
        return result;
    }
}
