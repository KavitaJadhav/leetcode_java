//https://leetcode.com/problems/largest-rectangle-in-histogram/
//Each bar is pushed once and popped once.
//| Metric | Value |
//| ------ | ----- |
//| Time   | O(n)  |
//| Space  | O(n)  |

//Approach Summary (Monotonic Stack):
//Use a stack to store (startIndex, height) of bars in increasing height order.
//When a smaller height appears, pop taller bars and compute area using height × (currentIndex - startIndex), updating startIndex so the new bar can extend left.
//After traversal, pop remaining bars and compute their areas using height × (n - startIndex) to get the maximum rectangle.

package stack;

import java.util.*;

public class LargeRectangleHistogram {

    class Node {
        int index;
        int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;

        // [2,1,5,6,2,3]
        stack.push(new Node(0, heights[0]));
        int index = 1;
        while (index < heights.length) {
            int start = index;
            while (!stack.isEmpty() && stack.peek().height > heights[index]) {
                Node node = stack.pop();
                area = node.height * (index - node.index);
                System.out.println(area);
                maxArea = Math.max(maxArea, area);
                start = node.index;
            }
            stack.push(new Node(start, heights[index]));
            index++;
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            area = node.height * (index - node.index);
            System.out.println(area);

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}