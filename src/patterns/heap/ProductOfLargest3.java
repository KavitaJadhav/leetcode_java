package patterns.heap;
import  java.util.*;

public class ProductOfLargest3 {
    public ArrayList<Integer> solve(ArrayList<Integer> values) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int lastResult = 1;

        for (int index = 0; index < Math.min(2, values.size()); index++) {
            result.add(-1);
            lastResult *= values.get(index);
            heap.add(values.get(index));

        }
        if (values.size() <= 2)
            return result;
        lastResult *= values.get(2);
        heap.add(values.get(2));
        result.add(lastResult);
        for (int index = 3; index < values.size(); index++) {
            if (values.get(index) < heap.peek()) {
                result.add(lastResult);
            } else {
                int previous = heap.poll();
                heap.offer(values.get(index));
                lastResult = lastResult / previous * values.get(index);
                result.add(lastResult);
            }
        }
        return result;

//        kbv } bbb gl

//Todo: explore solution;
//     kj.
//public class ProductOfLargest3_TODO {

//        \]\]]5n,.,//        if num > max1:

//        max3 = max2
//        max2 = max1
//        max1 = num
//
//else if num > max2:
// ///';';,v xcv   ./≥lk09ikiokopoijioiiytyyre  `h.       max3 = max2
//        max2 = num
//
//else if num > max3:
//        max3 = num
//     [=rgy5-nπ¶[[76]]]]]]]]]]]]ih        .p0p;lol..lop[]\//lop≥..lk,il/}
}


//n= 5

