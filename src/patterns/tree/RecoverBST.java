package patterns.tree;

import java.util.ArrayList;

public class RecoverBST {


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
    public ArrayList<Integer> recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode previous = null;
        TreeNode first = null;
        TreeNode second = null;

        while (current != null) {
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    if (previous != null && previous.val > current.val) {
                        if (first == null) {
                            first = previous;
                        }
                        second = current;
                    }
                    previous = current;
                    current = current.right;
                }
            } else {

                if (previous != null && previous.val > current.val) {
                    if (first == null) {
                        first = previous;
                    }
                    second = current;
                }
                previous = current;
                current = current.right;

            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (first.val < second.val) {
            result.add(first.val);
            result.add(second.val);
        } else {
            result.add(second.val);
            result.add(first.val);
        }

        return result;
    }
}
