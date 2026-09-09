//https://www.scaler.com/academy/mentee-dashboard/class/514022/homework/problems/383/submissions
package patterns.bit_manupulation;

import java.util.*;
//After sorting, the minimum XOR pair will always be among adjacent elements.
//Why only adjacent elements?
//XOR becomes small when two numbers have similar binary representations.
//Sorting puts numerically similar numbers next to each other.

public class MinXORArray {
    public int findMinXor(ArrayList<Integer> input) {
        Collections.sort(input);
        int result = Integer.MAX_VALUE;

        for(int index = 1; index <input.size(); index++){
            result = Math.min(result, input.get(index-1)^input.get(index));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();

        String values = scanner.next();

        for(String num : values.split(" ")){
            arrayList.add(Integer.parseInt(num));
        }

        MinXORArray minXORArray = new MinXORArray();
        System.out.println(minXORArray.findMinXor(arrayList));
    }
}
//001,010,011,100