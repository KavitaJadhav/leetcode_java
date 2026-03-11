package greedy;
//You cannot store primitive types directly in collections, but you can store arrays of primitives.

import java.util.*;

class OverLappingTimeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();

        int start = 0, end = 1;
        // [[1,6],[8,10],[15,18]]
        // Sort all intervals
        Arrays.sort(intervals, (a, b) -> a[start] - b[start]);

        int[] currentInterval = intervals[0];
        for (int index = 1; index < intervals.length; index++) {
            int[] nextInterval = intervals[index];

            if (currentInterval[end] >= nextInterval[start]) {
                currentInterval[start] = Math.min(currentInterval[start], nextInterval[start]);
                currentInterval[end] = Math.max(currentInterval[end], nextInterval[end]);
            } else {
                resultList.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        resultList.add(currentInterval);
        return resultList.toArray(new int[resultList.size()][]);

        // int[][] result = new int[resultList.size()][2];
        // int resultIndex = 0;

        // for(int[] interval : resultList){
        // }
        // return result;
    }
}