//https://leetcode.com/problems/daily-temperatures/

//Complexity
//Time Complexity
//O(n)
//Each index pushed once and popped once.

//Space Complexity
//O(n)
//Stack in worst case (strictly decreasing temperatures).

package stack;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int index = 1; index < temperatures.length; index++) {
            while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                int tempIndex = stack.pop();
                result[tempIndex] = index - tempIndex;
            }

            stack.push(index);
        }

        return result;
    }
}
