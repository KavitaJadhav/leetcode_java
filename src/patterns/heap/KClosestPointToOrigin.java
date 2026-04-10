//https://leetcode.com/problems/k-closest-points-to-origin/
//| Operation          | Complexity |
//| ------------------ | ---------- |
//| Heap insertion     | O(log k)   |
//| Total for N points | O(N log k) |
//| Space              | O(k)       |

//| Metric | Value                                   |
//| ------ | --------------------------------------- |
//| Time   | **O(N log k)** (patterns.heap insertions)        |
//| Space  | **O(k)** (patterns.heap stores at most k points) |
//Always use Integer.compare() in Java instead of b-a to avoid integer overflow.
//
//Max patterns.heap of size k is the canonical solution for K closest points problems.
//
//For a faster O(N) solution, QuickSelect can be used, but patterns.heap is safer for coding interviews.

package patterns.heap;

import java.util.*;

class KClosestPointToOrigin {
    class Point {
        int distanceSquare;
        int[] axis;

        public Point(int distanceSquare, int[] axis) {
            this.distanceSquare = distanceSquare;
            this.axis = axis;
        }

        public int[] getAxis() {
            return this.axis;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.distanceSquare, a.distanceSquare));

        for (int[] point : points) {

            int distanceSquare = (point[0] * point[0]) + (point[1] * point[1]);

            queue.offer(new Point(distanceSquare, point));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int index = 0; index < k; index++) {
            result[index] = queue.poll().getAxis();
        }
        return result;
    }
}