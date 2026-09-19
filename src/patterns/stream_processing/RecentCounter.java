//https://leetcode.com/problems/number-of-recent-calls/description/
//You have a RecentCounter class which counts the number of recent requests within a certain time frame.
//
//Implement the RecentCounter class:
//
//RecentCounter() Initializes the counter with zero recent requests.
//int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that have happened in the inclusive range [t - 3000, t], that is, the new request plus every earlier request that is no more than 3000 milliseconds older.
//It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

package patterns.stream_processing;

import java.util.*;

public class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int time) {
        int windowStart = time - 3000;
        while (!queue.isEmpty() && queue.peek() < windowStart) {
            queue.poll();
        }

        queue.offer(time);
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(3));
        System.out.println(recentCounter.ping(1000));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(5000));
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */