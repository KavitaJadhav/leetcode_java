package patterns.heap;

import java.util.*;

public class KthSubArrayLargest {

    public ArrayList<Integer> solve(int rank, ArrayList<Integer> list) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int index = 1; index < rank ; index++){
            heap.offer(list.get(index-1));
            result.add(-1);
        }

        heap.offer(list.get(rank - 1));
        result.add(heap.peek());

        for(int index=rank;index< list.size(); index++){
            Integer value = list.get(index);

            if(heap.peek()< value){
                heap.poll();
                heap.offer(value);
            }
            result.add(heap.peek());
        }

        return result;
    }
}
