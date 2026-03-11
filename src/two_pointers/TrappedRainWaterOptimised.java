//https://leetcode.com/problems/trapping-rain-water/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | **O(n)**   |
//| Space  | **O(1)**   |

//https://www.youtube.com/watch?v=ZI2z5pq0TqA
//https://www.youtube.com/watch?v=UHHp8USwx4M&pp=0gcJCZEKAYcqIYzv
//
//elevation map -topographic map, is a visual representation of the height of a geographic location relative to mean sea level.
//
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//
//Approach - two pointers moving for each directions indicating right and left height
//find the difference between abs(right-left)-index height
//move pointer with minimum height
//Update max height if new max height

//
//If you solved this in interview:
//Prefix/Suffix solution → Good
//Two pointer solution → Very strong signal
//Because this is a classic hard problem pattern.

package two_pointers;

class TrappedRainWaterOptimised {

    public int trap(int[] height) {
        int count = height.length;
        if (count <= 1) return 0;


        int maxLeftHeight = height[0], maxRightHeight = height[count - 1];
        int totalUnits = 0;
        int left = 0, right = count - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                maxLeftHeight = Math.max(maxLeftHeight, height[left]);
//                totalUnits += Math.max(maxLeftHeight - height[left], 0); Avoid Math.max as maxLeftHeight will be same or bigger. save calculation.
                totalUnits += maxLeftHeight - height[left];
                left++;
            } else {
                maxRightHeight = Math.max(maxRightHeight, height[right]);
                totalUnits += maxRightHeight - height[right];
                right--;
            }
        }
        return totalUnits;
    }
}