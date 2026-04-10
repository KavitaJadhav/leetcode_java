//https://leetcode.com/problems/merge-k-sorted-lists/
//| Metric | Value          |
//| ------ | -------------- |
//| Time   | **O(N log K)** |
//| Space  | **O(1)**       |
//Where
//N = total nodes
//K = number of lists


//| Approach             | Complexity       |
//| -------------------- | ---------------- |
//| Sequential merge     | O(NK) ❌          |
//| **Divide & Conquer** | **O(N log K)** ✅ |
//| Min Heap             | **O(N log K)** ✅ |

//| Approach         | Time       | Space | Difficulty |
//        | ---------------- | ---------- | ----- | ---------- |
//        | PriorityQueue    | O(N log K) | O(K)  | Easy       |
//        | Divide & Conquer | O(N log K) | O(1)  | Medium     |


        package patterns.heap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeListsHeap {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val-b.val);

        for(ListNode node :lists){
            if(node != null){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null){
                queue.add(node.next);
            }
            current.next = node;
            current = current.next;
        }

        return dummy.next;
    }

}