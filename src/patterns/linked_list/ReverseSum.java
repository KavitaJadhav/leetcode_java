package patterns.linked_list;

public class ReverseSum {
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode last= dummy;
        int remainder = 0;
        int sum=0;

        int num1;
        int num2;

// 119+111
// 119+null
// 1+9999

        while(list1!= null && list2!= null){
            num1 = list1.val;
            num2 = list2.val;

            sum = remainder + num1 + num2;
            remainder = sum/10;
            last.next = new ListNode(sum%10);
            last= last.next;

            list1=list1.next;
            list2 = list2.next;
        }

        while(list1!=null){
// System.out.print("list1 "+list1.val + "last "+last.val);

            sum = remainder + list1.val;
            remainder = sum/10;
            last.next = new ListNode(sum%10);
            last= last.next;
            list1=list1.next;
        }

        while(list2!=null){
            sum = remainder + list2.val;
            remainder = sum/10;
            last.next = new ListNode(sum%10);
            last= last.next;

            list2=list2.next;
        }

        if(remainder>0){
            last.next = new ListNode(remainder);
        }

        return dummy.next;
    }
}
