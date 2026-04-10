//https://leetcode.com/problems/min-stack/
//| Operation | Complexity |
//| --------- | ---------- |
//| push      | O(1)       |
//| pop       | O(1)       |
//| top       | O(1)       |
//| getMin    | O(1)       |
//| space     | O(n)       |

        package patterns.stack;

public class MinStack {


    class Node {
        int val;
        int minVal;
        Node previous;

        public Node(int val, int minVal, Node previous) {
            this.val = val;
            this.minVal = minVal;
            this.previous = previous;
        }
    }

    Node top;

    public MinStack() {}

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            top = new Node(val, Math.min(val, top.minVal), top);
        }
    }

    public void pop() {
//        Java GC will handle the rest.
        if (top != null) {
            top = top.previous;
        }
    }

    public int top() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.val;
    }

    public int getMin() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.minVal;
    }
}