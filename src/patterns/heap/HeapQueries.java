//https://www.scaler.com/academy/mentee-dashboard/class/514050/assignment/problems/94303/?navref=cl_pb_nv_tb
 package patterns.heap;

public class HeapQueries {

    public int[] solve(int[][] input) {
        Queue<Integer> heap = new PriorityQueue<>();
        List<Integer> result =new ArrayList<>();

        for(int[] pair : input){
            if(pair[0]==1 && pair[1]==-1){
                if(heap.isEmpty()){
                    result.add(-1);
                }else{
                    result.add(heap.poll());
                }
            }else{
                heap.offer(pair[1]);
            }
        }
        int[] array = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
