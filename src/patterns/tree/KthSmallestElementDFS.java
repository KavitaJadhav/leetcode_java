package patterns.tree;

public class KthSmallestElementDFS {
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
    int index = 0;
    int result;

    public int kthsmallest(TreeNode node, int k) {
        dfs(node, k);

        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null)
            return;
        dfs(node.left, k);

        index++;
        if (index == k) {
            result = node.val;
            return;
        }

        dfs(node.right, k);
    }
}
