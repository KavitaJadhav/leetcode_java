package patterns.array_reversal;

//https://leetcode.com/problems/rotate-array/
////| Operation | Complexity |
////| --------- | ---------- |
////| Time      | O(n)       |
////| Space     | O(1)       |


class RotateArrayKIndex {
    private void reverse(int[] nums, int startIndex, int endIndex){
        while(startIndex <= endIndex){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public void rotate(int[] nums, int count) {
        count = count % nums.length;
        int midIndex = nums.length - count;
        System.out.println(midIndex);
        reverse(nums, midIndex , nums.length-1);
        reverse(nums, 0, midIndex - 1 );
        reverse(nums, 0, nums.length-1);
    }
}