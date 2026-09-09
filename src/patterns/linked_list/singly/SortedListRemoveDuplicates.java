//https://www.scaler.com/academy/mentee-dashboard/class/523670/homework/problems/37/submissions
 package patterns.linked_list.singly;

public class SortedListRemoveDuplicates {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = head;
        ListNode current;

        while (previous != null) {
            current = previous.next;
            while (current != null && previous.val == current.val) {
                current = current.next;
            }
            previous.next = current;
            previous = current;
        }
        return head;
    }
}
