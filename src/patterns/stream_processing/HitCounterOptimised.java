//https://leetcode.com/problems/design-hit-counter/description/
//1. Problem
//
//Design a hit counter that counts the number of hits received in the past 5 minutes (300 seconds).
//
//Implement:
//
//hit(timestamp)
//getHits(timestamp)

package patterns.stream_processing;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterOptimised {
    int totalHits;
    Queue<int[]> queue;

    public HitCounterOptimised() {
        this.totalHits = 0;
        this.queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        if (!queue.isEmpty() && queue.peek()[0] == timestamp) {
            queue.peek()[1] += 1;
        } else {
            queue.offer(new int[]{timestamp, 1});
        }
        totalHits += 1;
    }

    public int getHits(int timestamp) {
        int windowStart = timestamp - 300;
//        note: Edge case at window start time - at time 500 valid window is from 201-500
        while (!queue.isEmpty() && queue.peek()[0] <= windowStart) {
            totalHits -= queue.poll()[1];
        }
        return totalHits;
    }

    public static void main(String[] args) {
        HitCounterOptimised counter = new HitCounterOptimised();
        counter.hit(1);
        counter.hit(3);
        counter.hit(100);
        counter.hit(301);
        System.out.println(counter.getHits(500));
        counter.hit(302);
        System.out.println(counter.getHits(400));
        counter.hit(500);

    }

}

//Complexity
//Time
//hit() - O(1)
//getHits() - O(1) amortized

//Space
//O(H)
//H = number of hits stored in the queue.
//Each timestamp is added once and removed once, so the total removal work across calls is amortized O(1) per hit.


//4. Interview follow-ups
//
//Think about these before moving on:
//1.
//Why is getHits() O(1) amortized instead of O(n) per call?
//Each hit is inserted once and removed at most once. Across many getHits() calls, the total number of removals is bounded by the number of inserted hits.
//
//2.
//Why must timestamps arrive in non-decreasing order?
//The queue's oldest timestamp is at the front. If timestamps arrive out of order, an expired timestamp might appear later in the queue, so removing from the front would not be sufficient.
//
//3.
//Why do we remove expired hits in getHits() rather than hit()?
//The problem only requires the count to be accurate when getHits() is called. Lazy cleanup is sufficient and keeps hit() O(1).
