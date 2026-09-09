//https://leetcode.com/problems/koko-eating-bananas/
//⏱ Complexity
//
//Time → O(n log m)
//Space → O(1)
//
//Where:
//n = number of piles
//m = max pile size
package patterns.binary_search.bsOnAnswer;

import java.util.Arrays;

class CocoEatingBanana {
    public int minEatingSpeed(int[] piles, int hours) {
        int upperLimit = Arrays.stream(piles).max().getAsInt();
        int lowerLimit = 1;
        int hoursToFinish, midLimit;
        while (lowerLimit < upperLimit) {
            hoursToFinish = 0;
            midLimit = (upperLimit + lowerLimit) / 2;
            for (int pile : piles) {
                hoursToFinish += (pile / midLimit);
                if (pile % midLimit > 0) hoursToFinish++;
            }
            // [3,6,7,11]

            if (hours >= hoursToFinish) {
                upperLimit = midLimit;
            } else {
                lowerLimit = midLimit + 1;
            }
        }
        return lowerLimit;
    }

    public static void main(String[] args) {
        System.out.println(new CocoEatingBanana().minEatingSpeed(new int[] {3,5,8,5}, 5));
    }
}