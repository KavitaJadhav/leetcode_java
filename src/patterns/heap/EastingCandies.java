//https://www.scaler.com/academy/mentee-dashboard/class/514050/homework/problems/1192/submissions
package patterns.heap;
import java.util.*;
public class EastingCandies {

    public int solve(ArrayList<Integer> candies, int limit) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;

        for(int value:candies){
            queue.offer(value);
        }

        while(!queue.isEmpty() && queue.peek()<=limit){
            int value = queue.poll();
            int consumed = value/2;
            result += consumed;
            if(!queue.isEmpty()){
                int next = queue.poll();
                queue.offer(next+(value-consumed));
            }

        }
        return result;
    }
}