package patterns.linked_list.doubly;

public class BreakLoop {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode head) {
        ListNode fast = head;
        ListNode fastPrevious = null;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
//            System.out.println("slow: " + slow.val + " fast prev : " + fastPrevious.val + "fast: " + fast.val);
            slow = slow.next;
            fast = fast.next;
            fastPrevious = fast;
            fast = fast.next;
            if (slow == fast)
                break;

        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fastPrevious = fast;
            fast = fast.next;
        }
        fastPrevious.next = null;

        return head;
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        BreakLoop breakLoop = new BreakLoop();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;


        ListNode result = breakLoop.solve(node1);
        breakLoop.print(result);

        BreakLoop breakLoop2 = new BreakLoop();
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(2);
        node21.next = node22;
        node22.next = node21;

        ListNode result2 = breakLoop.solve(node21);
        breakLoop.print(result2);
    }
}
