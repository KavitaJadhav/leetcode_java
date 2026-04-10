package patterns.binary_search;
//Working solution
//Find out whats wrong with my solution

//Summary
//Aspect	Complexity
//Time	    O(log(min(m, n)))
//Space	    O(1)
//Approach	Binary search on smaller array
//Works for	Arrays of different lengths, odd/even total, empty partitions

class SortedArraysMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is smaller
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalElements = nums1.length + nums2.length;
        int totalLeft = (totalElements + 1) / 2;

        int num1Left = 0;
        int num1Right = nums1.length;

        int num1Mid = 0, num2Mid = 0;

        while (num1Left <= num1Right) {
            num1Mid = (num1Left + num1Right) / 2;
            num2Mid = totalLeft - num1Mid;

            // Get left and right values, or null if out of bounds
            Integer left1 = (num1Mid == 0) ? null : nums1[num1Mid - 1];
            Integer right1 = (num1Mid == nums1.length) ? null : nums1[num1Mid];
            Integer left2 = (num2Mid == 0) ? null : nums2[num2Mid - 1];
            Integer right2 = (num2Mid == nums2.length) ? null : nums2[num2Mid];

            // Check if partition is valid
            boolean leftOk = (left1 == null || right2 == null || left1 <= right2);
            boolean rightOk = (left2 == null || right1 == null || left2 <= right1);

            if (leftOk && rightOk) {
                // Correct partition found
                int maxLeft = 0;
                if (left1 == null) maxLeft = left2;
                else if (left2 == null) maxLeft = left1;
                else maxLeft = Math.max(left1, left2);

                if (totalElements % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (right1 == null) minRight = right2;
                else if (right2 == null) minRight = right1;
                else minRight = Math.min(right1, right2);

                return (maxLeft + minRight) / 2.0;
            } else if (left1 != null && right2 != null && left1 > right2) {
                num1Right = num1Mid - 1; // Move left
            } else {
                num1Left = num1Mid + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
