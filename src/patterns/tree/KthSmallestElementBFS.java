package patterns.tree;

import java.util.Stack;

public class KthSmallestElementBFS {
    /**
     * Definition for binary tree
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
     * val = x;
     * left=null;
     * right=null;
     * }
     * }
     */

    public int kthsmallest(TreeNode node, int k) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;
        //    stack.push(node);

        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0)
                return current.val;
            current = current.right;
        }
    }
}
