//https://www.scaler.com/academy/mentee-dashboard/class/514053/homework/problems/385/?navref=cl_pb_nv_tb
package patterns.dynamic_programming.knapsack_unbounded;

import java.util.*;

public class FriendsAndDishes {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> eatingCapacity, final List<Integer> dishFillingCapacity, final List<Integer> dishCost) {
        // unbounded knapsack
        //
        if (eatingCapacity.size() == 0)
            return 0;
        int maxCapacity = Collections.max(eatingCapacity);
        int[] dp = new int[maxCapacity + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int index = 1; index <= maxCapacity; index++) {
            for (int dishCapacityIndex = 0; dishCapacityIndex < dishFillingCapacity.size(); dishCapacityIndex++) {
                int capacity = dishFillingCapacity.get(dishCapacityIndex);
                int cost = dishCost.get(dishCapacityIndex);
                if (capacity <= index)
                    dp[index] = Math.min(dp[index], cost + dp[index - capacity]);
            }
        }

        int result = 0;

        for (Integer capacity : eatingCapacity) {
            result += dp[capacity];
        }

        return result;
    }
}

// A = [2, 4, 6]
// B = [2, 1, 3]
// C = [2, 5, 3]
// dp -  max of A - 6
// 0,1,2,3,4,5,6
// 0,5,2,3,4,5,6
// 12