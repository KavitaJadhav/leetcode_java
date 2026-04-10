//https://leetcode.com/problems/container-with-most-water/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |

package patterns.two_pointers;

class ContainerWithWater {
    public int maxArea(int[] heights) {
        if (heights.length <= 1) return 0;
        int left = 0, right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {
            int waterUnits = (right - left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, waterUnits);

            if (heights[left] < heights[right]) left++;
            else right--;
        }

        return maxWater;
    }
}
