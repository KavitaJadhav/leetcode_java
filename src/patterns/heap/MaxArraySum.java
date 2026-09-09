//https://www.scaler.com/academy/mentee-dashboard/class/514050/homework/problems/4395/submissions
package patterns.heap;
import java.util.*;
public class MaxArraySum {
    public int solve(ArrayList<Integer> values, int operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(Integer value: values){
            queue.offer(value);
        }
        int counter = 0;
        while(counter<operations){
            int value = queue.poll();
            queue.offer(value * -1);
            counter++;
        }
        int result = 0;
        while(!queue.isEmpty()){
            result+= queue.poll();
        }
        return result;
    }
}
//  A = [24, -68, -29, -9, 84]
//  B = 4


