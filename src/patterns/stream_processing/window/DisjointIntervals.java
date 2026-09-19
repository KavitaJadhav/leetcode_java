//https://leetcode.com/problems/data-stream-as-disjoint-intervals/?utm_source=chatgpt.com
//Complexity
//addNum() → O(log I)
//getIntervals() → O(I)
//Space → O(I)

package patterns.stream_processing.window;

import java.util.*;

public class DisjointIntervals {
    class SummaryRanges {
        TreeMap<Integer, Integer> map ;

        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int value) {
            Map.Entry<Integer, Integer> previous = map.floorEntry(value);
            Map.Entry<Integer,Integer> next = map.ceilingEntry(value);

            System.out.print(" prev "+previous);
            System.out.print(" next"+next);

            // Value present as part of existing interval
            if(previous!=null && value<=previous.getValue()){

                return;
            }

            // joins both Intervals
            if(previous!=null && next!=null && value==previous.getValue()+1 && value==next.getKey()-1){
                map.put(previous.getKey(), next.getValue());
                map.remove(next.getKey());
                return;
            }

            // extend previous interval
            if(previous!=null &&  value==previous.getValue()+1 ){
                map.put(previous.getKey(), value);
                return;
            }
            // extends next interval
            if(next!=null && value==next.getKey()-1){
                map.put(value, next.getValue());
                map.remove(next.getKey());
                return;
            }
            // creates a new interval
            map.put(value, value);
        }

        public int[][] getIntervals() {
            int[][] result = new int[map.keySet().size()][2];
            int index = 0;
            for(Integer key : map.keySet()){
                result[index] = new int[]{key, map.get(key)};
                index++;
            }
            return result;
        }
    }


}


/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
