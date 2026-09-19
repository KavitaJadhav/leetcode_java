package patterns.heap;
//https://www.scaler.com/academy/mentee-dashboard/class/514061/homework/problems/4950?navref=cl_tt_nv
public class kthSmallestFromMatrix {

    public int solve(ArrayList<ArrayList<Integer>> lists, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int index = 0; index< lists.size(); index++){
            queue.offer(lists.get(index));
        }

        int value;
        for(int index = 0; index<k index++){
            value = heap.poll
        }
    }
}
