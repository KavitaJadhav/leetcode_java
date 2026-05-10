//https://leetcode.com/problems/asteroid-collision/
//You have an array of integers:
//Negative values → move left
//Positive values → move right
//But collisions happen:
//When a positive number (moving right) meets a negative number (moving left)
//Collision rules:
//Smaller absolute value gets destroyed
//If equal → both destroyed
//Same direction → no collision

//Complexity
//Time: O(n)
//Space: O(n)
package patterns.stack;

import java.util.ArrayList;
import java.util.Stack;

public class AsteroidCollision {
    public ArrayList<Integer> asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            boolean alive = true;

            // collision happens only when:
            // current is negative & stack top is positive
            while (alive && num < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (Math.abs(num) > stack.peek()) {
                    stack.pop(); // destroy stack top
                } else if (Math.abs(num) == stack.peek()) {
                    stack.pop(); // both destroyed
                    alive = false;
                } else {
                    alive = false; // current destroyed
                }
            }

            if (alive) {
                stack.push(num);
            }
        }

        // Convert stack → ArrayList
        return new ArrayList<>(stack);
    }
}


//import java.util.*;

//public class Solution {
//    public int[][] insert(int[][] A, int[] B) {
//        List<int[]> result = new ArrayList<>();
//
//        int index = 0;
//
//        int[] currentInterval = B;
//
//        // 1. Add all intervals before B
//        while (index < A.length && A[index][1] < currentInterval[0]) {
//            result.add(A[index]);
//            index++;
//        }
//
//        // 2. Merge overlapping intervals with B
//        while (index < A.length && A[index][0] <= currentInterval[1]) {
//            currentInterval[0] = Math.min(currentInterval[0], A[index][0]);
//            currentInterval[1] = Math.max(currentInterval[1], A[index][1]);
//            index++;
//        }
//
//        result.add(currentInterval);
//
//        // 3. Add remaining intervals
//        while (index < A.length) {
//            result.add(A[index]);
//            index++;
//        }
//
//        return result.toArray(new int[result.size()][]);
//    }
//}