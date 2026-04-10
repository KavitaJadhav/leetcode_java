//https://leetcode.com/problems/linked-list-cycle/
//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |

package patterns.linked_list;

public class DetectLoop {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}