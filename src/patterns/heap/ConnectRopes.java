//https://www.scaler.com/academy/mentee-dashboard/class/514050/assignment/problems/4385?navref=cl_tt_lst_sl
package patterns.heap;


public class ConnectRopes {

    public int solve(ArrayList<Integer> list) {
        Queue<Integer> queue = new PriorityQueue<>();

        for(Integer value : list){
            queue.offer(value);
        }
        int result =0;
        // int previous = queue.poll();

        // while(!queue.isEmpty()){
        //     result+= (previous + queue.poll());
        //     previous= result;
        // }
        int part1,part2;

        while(queue.size()>1){
            part1 = queue.poll();
            part2 = queue.poll();
            int next = part1 +part2;
            result+= next;
            queue.offer(next);
        }

        return result;
    }
}
