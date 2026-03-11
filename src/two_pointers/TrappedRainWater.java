//https://leetcode.com/problems/trapping-rain-water/
//| Metric | Complexity            |
//| ------ | --------------------- |
//| Time   | **O(n)**              |
//| Space  | **O(n)** (two arrays) |

//https://www.youtube.com/watch?v=ZI2z5pq0TqA
//https://www.youtube.com/watch?v=UHHp8USwx4M&pp=0gcJCZEKAYcqIYzv
//
//elevation map -topographic map, is a visual representation of the height of a geographic location relative to mean sea level.
//
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

        
package two_pointers;

class TrappedRainWater {
    public int trap(int[] height) {
        int count = height.length;
        if(count==0) return 0;

        int[] maxLeftHeight = new  int[count];
        int[] maxRightHeight = new int[count];

        int totalUnits = 0;
        maxLeftHeight[0]=height[0];
        for(int index=1; index<count; index++){
            maxLeftHeight[index] = Math.max(maxLeftHeight[index-1], height[index]);
        }

        maxRightHeight[count-1] = height[count-1];
        for(int index=count-2; index>=0; index--){
            maxRightHeight[index] = Math.max(maxRightHeight[index+1], height[index]);
        }
//        First and last index cannot trap water
        for(int index=1; index<count-1; index++){
            int trappedWaterUnits = Math.min(maxLeftHeight[index], maxRightHeight[index]) - height[index];
            totalUnits+= Math.max(0, trappedWaterUnits);
        }

        return totalUnits;
    }
}