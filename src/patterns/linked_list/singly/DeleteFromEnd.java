//dummy + fast/slow gap template
//Remove Nth Node
//Find kth node from end
//Middle of linked list
//Split linked list
//Palindrome linked list
//Reorder list

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
package patterns.linked_list.singly;

public class DeleteFromEnd {

    class ListNode {
        public int val;
        public InsertNode.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int index = 0; index < n; index++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class DeleteFromEndOld {

    class ListNode {
        public int val;
        public InsertNode.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iterator = head;
        ListNode delay = head;
        ListNode previousDelay = null;
        int counter = 1;
        while (iterator != null) {
            if (counter > n) {
                previousDelay = delay;
                delay = delay.next;
            }
            iterator = iterator.next;
            counter++;
        }
        if (previousDelay == null) {
            return head.next;
        } else {
            previousDelay.next = delay.next;
            return head;
        }
    }
}
