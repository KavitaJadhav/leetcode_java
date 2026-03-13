//https://leetcode.com/problems/reverse-linked-list/

//Approach
// Use two pointers: prev (initially null) and curr (initially head).
//Iterate through the list, at each step:
//Save next = curr.next
//Reverse the link: curr.next = prev
//Move pointers forward: prev = curr, curr = next
//At the end, prev points to the new head of the reversed list.


//| Metric | Complexity |
//| ------ | ---------- |
//| Time   | O(n)       |
//| Space  | O(1)       |

package LinkedList;

import java.util.*;

public class ReverseSinglyLinkList {


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

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
