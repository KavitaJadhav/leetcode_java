//9️⃣ Why QuickSelect is used in Interviews
//
//It solves problems like:
//
//K closest points to origin
//
//Kth largest element
//
//Top K frequent elements
//
//Median of unsorted array
//
//And it is faster than heap O(n log k) for large inputs.
//
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

//| Metric         | Value    |
//| -------------- | -------- |
//| Time (Average) | **O(n)** |
//| Time (Worst)   | O(n²)    |
//| Space          | **O(1)** |

//Incomplete solution - few specs failing
package heap;

class KthLargestElementQuickSelect {

    private int pivotIndex(int[] nums, int left, int right) {
        int pivot = right;
        for (int index = left; index <= pivot; index++) {
            if (nums[index] > nums[pivot]) {
                while ((pivot - 1) != index) {
                    int temp = nums[index];
                    nums[index] = nums[pivot - 1];
                    nums[pivot - 1] = nums[pivot];
                    nums[pivot] = temp;
                    pivot--;
                }
                int temp = nums[index];
                nums[index] = nums[pivot];
                nums[pivot] = temp;
                pivot--;


            }
        }
        return pivot;
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int kthIndex = nums.length - k;

        while (left <= right) {
            int pivot = pivotIndex(nums, left, right);

            if (pivot == kthIndex) return nums[pivot];

            if (pivot < kthIndex)
                left = pivot + 1;
            else
                right = pivot - 1;


        }
        return -1;
    }
}
