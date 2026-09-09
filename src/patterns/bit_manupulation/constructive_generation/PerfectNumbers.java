//https://www.scaler.com/academy/mentee-dashboard/class/514064/homework/problems/3297/?navref=cl_pb_nv_tb
package patterns.bit_manupulation.constructive_generation;

public class PerfectNumbers {
    public String solve(int input) {
        int length = 2;
        while(true){
            // System.out.print("input "+ input+",");

            int elements = (int)Math.pow(2, (length/2));
            if(input<=elements)
                break;
            input-=elements;
            length+=2;
        }
        int halfLength = length/2;

        String binaryHalf = Integer.toBinaryString(input-1); //binary represenattion starts from 0

        while(binaryHalf.length()<halfLength){
            binaryHalf = "0"+binaryHalf;
        }
        // System.out.print("binaryHalf "+ binaryHalf+",");
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < binaryHalf.length(); index++){
            if(binaryHalf.charAt(index)=='0'){
                result.insert(index, '1');
                result.insert(index+1, '1');}
            else{
                result.insert(index, '2');
                result.insert(index+1, '2');  }
        }

        return result.toString();
    }
}
// Bit Manipulation-Binary Representation-Constructive Generation
// A = 25
// → length = 8
// → halfLength = 4
// → adjusted A = 11
// → A - 1 = 10
// → binary = 1010
// → firstHalf = 2121
// → secondHalf = 1212
// → answer = 21211212