//https://leetcode.com/problems/merge-sorted-array/
//| Metric | Complexity |                            |
//| ------ | ---------- | -------------------------- |
//| Time   | O(m + n)   |                            |
//| Space  | O(1)       | (in-place, no extra array) |

package two_pointers;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Right = m-1;
        int nums2Right = n-1;
        int nums1FilledIndex = nums1.length-1;

        while(nums2Right>=0 && nums1Right>=0){
            if(nums2[nums2Right] > nums1[nums1Right]){
                nums1[nums1FilledIndex] = nums2[nums2Right];
                nums2Right--;
            }else{
                nums1[nums1FilledIndex] = nums1[nums1Right];
                nums1Right--;
            }
            nums1FilledIndex--;
        }

        while(nums2Right>=0){
            nums1[nums1FilledIndex] = nums2[nums2Right];
            nums2Right--;
            nums1FilledIndex--;

        }
    }
}
