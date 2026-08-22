package patterns.tree;

import java.util.ArrayList;

public class MorrisInorderTraverse {

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
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        TreeNode current = root;
        TreeNode inorderPredecesser;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                inorderPredecesser = current.left;

                while (inorderPredecesser.right != null && current != inorderPredecesser.right) {
                    inorderPredecesser = inorderPredecesser.right;
                }

                if (inorderPredecesser.right == null) {
                    inorderPredecesser.right = current;
                    current = current.left;
                } else {
                    inorderPredecesser.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
