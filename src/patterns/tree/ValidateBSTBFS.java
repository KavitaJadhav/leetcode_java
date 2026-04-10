//Complexity
//        Time: O(N) — visit each node once
//        Space: O(N) — the queue can hold up to all nodes at a level

package patterns.tree;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    public TreeNode() {}

    // Constructor with value
    public TreeNode(int val) {
        this.val = val;
    }

    // Constructor with value, left, and right children
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ValidateBSTBFS {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // Queue of node + valid range for that node
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            long min = curr.min, max = curr.max;

            if (node.val <= min || node.val >= max) return false;

            if (node.left != null)
                queue.offer(new Tuple(node.left, min, node.val));
            if (node.right != null)
                queue.offer(new Tuple(node.right, node.val, max));
        }

        return true;
    }

    // Helper class to keep node and its valid min/max bounds
    private static class Tuple {
        TreeNode node;
        long min, max;
        Tuple(TreeNode n, long mi, long ma) {
            node = n; min = mi; max = ma;
        }
    }
}