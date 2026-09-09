//https://leetcode.com/problems/search-in-rotated-sorted-array/
//📦 Time Complexity
//✅ O(log n)
//Why?
//At every recursive call, you eliminate half of the array.
//Even though the array is rotated, you still discard one half each time.
//Rotation does not change binary search complexity.
//
//📦 Space Complexity
//Since you're using recursion:
//✅ O(log n)
//Why?
//Each recursive call goes deeper by half.
//Maximum recursion depth = log n.
//That patterns.stack space counts.

// Note: Interview preference 0(1) space complexity - iterative
package patterns.binary_search.rotated_array;

class RotatedSortedArrayRecursive {
    private int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex) / 2;
// [,8,9,1,2,3,4,5,6,7]
// [4,5,6,7,0,1,2]

        if (nums[midIndex] == target) {
            return midIndex;
        }

        if (nums[startIndex] <= nums[midIndex]) {
            if (target < nums[midIndex] && target >= nums[startIndex]) {
                return binarySearch(nums, target, startIndex, midIndex - 1);
            } else {
                return binarySearch(nums, target, midIndex + 1, endIndex);
            }
        } else {
            if (target > nums[midIndex] && target <= nums[endIndex]) {
                return binarySearch(nums, target, midIndex + 1, endIndex);

            } else {
                return binarySearch(nums, target, startIndex, midIndex - 1);
            }
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        RotatedSortedArrayRecursive rotatedSortedArray = new RotatedSortedArrayRecursive();
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{}, 2));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{1}, 0));

    }
}

//📦 Time Complexity
//✅ O(log n)
//📦 Space Complexity
//✅ O(1)

class RotatedSortedIterative {

    // [,8,9,1,2,3,4,5,6,7]
    // [4,5,6,7,0,1,2]

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;

            if (nums[midIndex] == target) return midIndex;

            if (nums[startIndex] <= nums[midIndex]) {
                if (target < nums[midIndex] && target >= nums[startIndex]) endIndex = midIndex - 1;
                else startIndex = midIndex + 1;
            } else {
                if (target > nums[midIndex] && target <= nums[endIndex]) startIndex = midIndex + 1;
                else endIndex = midIndex - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        RotatedSortedIterative rotatedSortedArray = new RotatedSortedIterative();
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{}, 2));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Search: " + rotatedSortedArray.search(new int[]{1}, 0));

    }
}