package patterns.tree;

public class CompareTrees {
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
    public int isSameTree(TreeNode node1, TreeNode node2) {
        return compare(node1, node2) ? 1 : 0;
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null)
            return node1 == node2;

        return node1.val == node2.val && compare(node1.left, node2.left) && compare(node1.right, node2.right);
    }
}

