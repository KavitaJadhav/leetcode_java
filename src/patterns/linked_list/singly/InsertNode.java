//https://www.scaler.com/academy/mentee-dashboard/class/523670/assignment/problems/30536/?navref=cl_pb_nv_tb
package patterns.linked_list.singly;

public class InsertNode {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode head, int value, int index) {
        ListNode node = new ListNode(value);
        if (head == null)
            return node;

        if (index == 0) {
            node.next = head;
            return node;
        }

        ListNode current = head;
        int currentIndex = 0;

        while (current.next != null && currentIndex < (index - 1)) {
            current = current.next;
            currentIndex++;
        }
        node.next = current.next;
        current.next = node;
        return head;
    }
}
