//https://www.scaler.com/academy/mentee-dashboard/class/523670/assignment/problems/30667/submissions
package patterns.linked_list.singly;

public class DeleteNodeFromEnd {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        int count = 1;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        int total = (count * 2);
        if (fast == null)
            total--;
        int deleteIndex = n > total ? 0 : total - n;
        return delete(head, deleteIndex);
    }

    public ListNode delete(ListNode head, int index) {
        if (index == 0)
            return head.next;

        ListNode current = head;
        int currentIndex = 0;
        while (current.next != null && currentIndex < (index - 1)) {
            current = current.next;
            currentIndex++;
        }


        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }
}

class DeleteNodeFromEndOptimised {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null)
                return head;

            ListNode slow = head;
            ListNode fast = head;

            // Move fast B nodes ahead
            for (int index = 0; index < n; index++) {
                if (fast == null)
                    return head.next;

                fast = fast.next;
            }

            // B is greater than size
            if (fast == null)
                return head.next;

            // Move both until fast reaches the last node
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            // Remove B-th node from the end
            slow.next = slow.next.next;

            return head;
        }
    }

}
