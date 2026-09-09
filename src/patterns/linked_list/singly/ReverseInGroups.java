package patterns.linked_list.singly;

public class ReverseInGroups {
    class ListNode {
        public int val;
        public InsertNode.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head, int groupSize) {
        if (head == null || head.next == null || groupSize == 1)
            return head;

        ListNode previous = null;
        ListNode current = head;
        ListNode grouptail = head;
        ListNode next;
        int count = 0;


        ListNode dummy = new ListNode(0);
        ListNode previousEnd = dummy;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
            if (count == groupSize) {
                previousEnd.next = previous;
                previousEnd = grouptail;
                grouptail = current;
                previous = null;
                count = 0;
            }
        }
        return dummy.next;
    }
}

//Todo: Explore this solution
public class ReverseInGroupsAlternative {
    class ListNode {
        public int val;
        public InsertNode.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseList(ListNode head, int groupSize) {
        if (head == null || groupSize == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode previousEnd = dummy;
        ListNode current = head;

        while (current != null) {

            // Find the end of the current group
            ListNode groupEnd = current;

            for (int index = 1; index < groupSize; index++) {
                groupEnd = groupEnd.next;
            }

            // Since B divides the length, groupEnd will not be null
            ListNode nextGroup = groupEnd.next;

            // Reverse current group
            ListNode previous = nextGroup;
            ListNode node = current;

            while (node != nextGroup) {
                ListNode next = node.next;
                node.next = previous;
                previous = node;
                node = next;
            }

            // Connect previous group to reversed group
            previousEnd.next = groupEnd;

            // Current is now the tail of the reversed group
            previousEnd = current;
            current = nextGroup;
        }

        return dummy.next;
    }
}