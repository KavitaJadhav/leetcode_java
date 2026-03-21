//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

//⏱ Complexity
//Binary search over capacity.
//Time:  O(N log S)
//Space: O(1)
//
//Where:
//N = number of packages
//S = sum(weights)
//Note: s-> sum(weights), as search will be tracked down from sum count.
package binary_search;
import java.util.*;
class ShipPackagesDDays {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = Arrays.stream(weights).max().getAsInt();
//        Therefore the minimum possible capacity must be at least the largest weight.
//        If the ship capacity is smaller than the largest package, that package can never be shipped.

        int maxCapacity = Arrays.stream(weights).sum();
        int daysToShip;
        int weightsSum;
        // [1,2,3,4,5,6,7,8,9,10]

        while(minCapacity != maxCapacity) {
            int midCapacity = (minCapacity+maxCapacity)/2;
            daysToShip = 0;
            weightsSum = 0;
            for(int weight : weights){
                if((weightsSum + weight) > midCapacity){
                    daysToShip++;
                    weightsSum = 0;
                }
                weightsSum+=weight;
            }
            daysToShip++;


            if(daysToShip > days){

                minCapacity = midCapacity +1;
            }else{
                System.out.println(daysToShip);
                System.out.println(minCapacity);
                System.out.println(maxCapacity);

                maxCapacity= midCapacity;
            }
        }
        return minCapacity;
    }
}