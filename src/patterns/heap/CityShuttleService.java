package patterns.heap;

import java.util.*;

public class CityShuttleService {

    public int canHandleAllRequests(ArrayList<ArrayList<Integer>> input, int capacity) {
        Collections.sort(input, (a,b)->
        {if(a.get(1)==b.get(1)){
            return a.get(2)-b.get(2);
        }
        else{
            return a.get(1)-b.get(1);
        }});
        // a.get(1)-b.get(1));
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<>(Comparator.comparingInt((a)-> a.get(2)));

        int available = capacity;
        for(int index = 0; index<input.size(); index++){
            // System.out.print(" ," + )
            ArrayList<Integer> current = input.get(index);

// System.out.print(" ,"+current.get(1)+" "+current.get(2)+" "+available);
            while(!heap.isEmpty() && heap.peek().get(2)<=current.get(1)){
                ArrayList<Integer> old = heap.poll();
                // System.out.print(" bf "+ available);
                available+=old.get(0);
                // System.out.print(" old "+ old.get(2)+ "av "+ available);
                // available=+old.get(0);
            }

            if(available>=current.get(0)){
                heap.offer(current);
                available-=current.get(0);
            }else{
                return 0;
            }
        }
        return 1;
    }
}
