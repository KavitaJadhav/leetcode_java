//https://www.scaler.com/academy/mentee-dashboard/class/523670/assignment/problems/30667/submissions
 package patterns.linked_list.singly;

public class DeleteNode {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode head, int index) {
        if(index == 0)
            return head.next;

        ListNode current = head;
        int currentIndex = 0;
        while(current.next != null && currentIndex < (index-1)){
            current = current.next;
            currentIndex++;
        }


        if(current.next != null){
            current.next = current.next.next;
        }

        return head;
    }
}
