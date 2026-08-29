//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/185198/submissions
package patterns.greedy;

import java.util.ArrayList;

public class JumpGame {

    public int solve(ArrayList<Integer> jumps) {
        if(jumps.size()<=1)
            return 0;
        int targetIndex = jumps.size()-1;
        int currentEnd = 0;
        int result = 0;
        int currentFar = 0;
        // currentEnd-end of the range reachable with current jumps
        // currentFar-farthest position reachable from the current range
        // result-number of jumps

        for(int index = 0; index < targetIndex; index++){
            currentFar = Math.max(currentFar, index+jumps.get(index));

            if(index==currentEnd){
                result++;
                currentEnd=currentFar;

                if(currentEnd>= targetIndex)
                    return result;

                if(currentEnd==index) //progress is stuck at the index [3, 2, 1, 0, 4], no way to move ahead after index 3
                    return -1;

            }

        }

        return -1;
    }
}

// [2, 3, 1, 1, 4]