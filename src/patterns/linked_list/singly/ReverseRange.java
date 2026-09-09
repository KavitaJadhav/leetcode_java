//https://www.scaler.com/academy/mentee-dashboard/class/523670/homework/problems/45/submissions
//Todo: revisit again
package patterns.linked_list.singly;

public class ReverseRange {
    class ListNode {
        public int val;
        public InsertNode.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode reverseBetween(ListNode head, int from, int to) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;

        int count = 1;
        while (count < from) {
            previous = current;
            current = current.next;
            count++;
            if (current == null)
                return head;
        }
        ListNode beforeFrom = previous;

        ListNode fromNode = current;
        while (current != null && count <= to) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
            // if(count==to)
            //     break;

        }
        if (beforeFrom != null)
            beforeFrom.next = previous;
        else
            head = previous;

        // fromNode.next = next;

        return head;

    }
}
