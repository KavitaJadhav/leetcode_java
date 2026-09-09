//https://www.scaler.com/academy/mentee-dashboard/class/523670/assignment/problems/30536?navref=cl_tt_nv
package patterns.linked_list.singly;

import java.util.*;

public class DeepCopyRandom {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        public RandomListNode copyRandomList(RandomListNode head) {
            Map<RandomListNode, RandomListNode> map = new HashMap<>();

            RandomListNode current = head;
            while (current != null) {
                map.put(current, new RandomListNode(current.label));
                current = current.next;
            }

            current = head;
            while (current != null) {
                RandomListNode mapped = map.get(current);

                mapped.next = map.get(current.next);
                mapped.random = map.get(current.random);
                current = current.next;
            }
            return map.get(head);
        }

    }
}
