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


        package patterns.heap;
import java.util.*;
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
class MergeListsMergeSort {
    private ListNode merge(ListNode node1, ListNode node2){
        if(node1==null) return node2;
        if(node2==null) return node1;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(node1!=null && node2 != null){
            if(node1.val < node2.val){
                current.next = node1;
                current = node1;
                node1 = node1.next;
            }else{
                current.next = node2;
                current = node2;
                node2 = node2.next;
            }
        }

        if(node1!=null){
            current.next = node1;
        }

        if(node2!=null){
            current.next = node2;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;

        List<ListNode> nodesList = new ArrayList<>(Arrays.asList(lists));
        while(nodesList.size() > 1){
            List<ListNode> mergeLists = new ArrayList<>();
            for(int index = 0; index<nodesList.size(); index+=2 ){
                mergeLists.add( merge(nodesList.get(index),
                        index+1==nodesList.size() ? null : nodesList.get(index+1)
                ));
            }

            nodesList = mergeLists;
        }
        return  nodesList.get(0);
    }
}