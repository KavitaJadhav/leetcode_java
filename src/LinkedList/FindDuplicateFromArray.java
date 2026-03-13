//https://leetcode.com/problems/find-the-duplicate-number/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |


//Approach (Floyd’s Cycle Detection in Array Form):
//Treat the array as a linked list: index → nums[index].
//Use slow and fast pointers to detect the cycle.
//Reset slow to start and move both one step at a time to find the entrance of the cycle.
//The entrance is the duplicate number.

package LinkedList;

public class FindDuplicateFromArray {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}