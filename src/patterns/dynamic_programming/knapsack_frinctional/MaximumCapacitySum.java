//https://www.scaler.com/academy/mentee-dashboard/class/514053/assignment/problems/35883/?navref=cl_pb_nv_tb
//Complexity
//Creating tuples:    O(N)
//Sorting:            O(N log N)
//Greedy traversal:   O(N)
//Total:              O(N log N)
//Space:              O(N)

package patterns.dynamic_programming.knapsack_frinctional;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumCapacitySum {

    class Tuple{
        public int value;
        public int weight;
        public Tuple(int value, int weight){
            this.weight = weight;
            this.value = value;
        }
    }

    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int capacityWeight) {
        if(values.size()==0 || capacityWeight==0)
            return 0;
        Tuple[] tuples = new Tuple[values.size()];

        for(int index = 0; index< values.size(); index++){
            tuples[index] = new Tuple(values.get(index), weights.get(index));
        }

        Arrays.sort(tuples, (a, b) -> Double.compare((double) b.value/b.weight, (double) a.value/a.weight));

        int tupleIndex = 0;
        double result = 0.0;
        while(capacityWeight>0 && tupleIndex<tuples.length){
            Tuple tuple= tuples[tupleIndex];
            if(tuple.weight <= capacityWeight){
                result+= (double) (tuple.value*100);
                capacityWeight-=tuple.weight;
            }else{
                result+= ((double) (tuple.value*100)/tuple.weight * capacityWeight);
                capacityWeight=0;
            }
            // System.out.print(" " +result);
            tupleIndex++;
        }
        return (int) Math.floor(result);
//        Note: avoiding multiplication here to achieve precision in result.
        // return (int) Math.floor(result * 100);

    }
}

//  A = [60, 100, 120]
//  B = [10, 20, 30]
//  C = 50
// per unit/friction
// [6,5,4]
// 60+100+80=240*100 = 24000