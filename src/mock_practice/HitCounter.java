//* https://leetcode.com/problems/design-hit-counter/
// LeetCode: Design Hit Counter
package mock_practice;

import java.util.*;

class HitCounter {

    private Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        // remove outdated hits (> 300 seconds old)
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}