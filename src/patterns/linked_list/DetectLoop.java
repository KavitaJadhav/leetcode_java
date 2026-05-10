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

        while (fast != null && fast.next != null) { //Slow will be inbound if fast is inbound
            slow = slow.next;
            fast = fast.next.next; //fast can be nil here, so loop will end in next iteration
            if (slow == fast) return true;
        }
        return false;
    }
}