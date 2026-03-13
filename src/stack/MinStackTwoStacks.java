//| Metric   | Two-Stack MinStack |
//| -------- | ------------------ |
//| `push`   | O(1)               |
//| `pop`    | O(1)               |
//| `top`    | O(1)               |
//| `getMin` | O(1)               |
//| Space    | O(n)               |

//| Operation       | Complexity | Explanation                                                                           |
//| --------------- | ---------- | ------------------------------------------------------------------------------------- |
//| `push(int val)` | **O(1)**   | Only two `push()` operations (stack + possibly minStack). Comparing `peek()` is O(1). |
//| `pop()`         | **O(1)**   | Only two `pop()` operations at most. `peek()` and `Objects.equals()` are O(1).        |
//| `top()`         | **O(1)**   | Just `stack.peek()`.                                                                  |
//| `getMin()`      | **O(1)**   | Just `minStack.peek()`.                                                               |

//2️⃣ Space Complexity
//Let n = number of elements in the stack.
//stack stores all elements → O(n)
//minStack stores only minima → worst case O(n) (if elements are strictly decreasing)
//So overall space complexity = O(n)
//Best case: elements are strictly increasing → minStack is small → O(1) extra space
//Worst case: elements are strictly decreasing → minStack grows to size n → O(n) extra space

        package stack;

import java.util.Objects;
import java.util.Stack;

public class MinStackTwoStacks {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStackTwoStacks() {}

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (Objects.equals(stack.peek(), minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}