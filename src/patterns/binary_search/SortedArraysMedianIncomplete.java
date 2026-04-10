//https://www.youtube.com/watch?v=q6IEA26hvXc
//https://leetcode.com/problems/median-of-two-sorted-arrays

    // Summary
//Aspect	Complexity
//Time	    O(log(min(m, n)))
//Space	    O(1)
//Approach	Binary search on smaller array
//Works for	Arrays of different lengths, odd/even total, empty partitions

//Find out what's wrong with my solution
//Issues - right index range not updated..
package patterns.binary_search;

class SortedArraysMedianIncomplete {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // [1,2]
        // [3,4]
        // Mean - The sum of all values divided by the number of values.
        // Median -The middle value when numbers are sorted. Even size array- middle of 2 mid values
        // Mode - The value that appears most frequently.

        //  Solution considering nums1 will be smaller in length. if not, swap input.

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int totatElements = nums1.length+nums2.length;
        int finalMidIndex =( nums1.length+nums2.length + 1)/2;

        int num1Left, num1Right, num1Mid,num2Left, num2Right, num2Mid;

        num1Left = 0;
        num1Mid = 0;
        num1Right = nums1.length -1;

        num2Left = 0;
        num2Mid = 0;

        num2Right = nums2.length -1;


        while(num1Left<=num1Right){

            num1Mid = (num1Left + num1Right)/2;
            num2Mid = finalMidIndex - num1Mid;

            if(num1Mid < num1Right && num2Mid < num2Right){
                if(nums2[num2Mid+1] < nums1[num1Mid]){
                    num2Left= num2Mid+1;
                }
                if(nums1[num1Mid+1] < nums2[num2Mid]){
                    num1Left= num1Mid+1;
                }
            }
        }

        if( totatElements % 2 != 0){
            return Math.max(nums1[num1Mid], nums2[num2Mid]);
        }else{
            int midFromRight =  Math.min(num1Mid < num1Right  ? nums1[num1Mid + 1] : 0, num2Mid < num2Right  ? nums2[num2Mid + 1] : 0);

            System.out.println(midFromRight);
            return( Math.max(nums1[num1Mid], nums2[num2Mid]) + midFromRight )/ 2;
        }
    }
}