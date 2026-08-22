package patterns.tree;

public class PathSumFromRoot {
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
    public int hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return -1;

        return path(root, sum) == true ? 1 : 0;
    }

    private boolean path(TreeNode node, int sum) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null)
            return node.val == sum;

        return path(node.left, sum - node.val) || path(node.right, sum - node.val);
    }

}
