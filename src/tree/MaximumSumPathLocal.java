//📊 Complexity
//
//Time: O(N)
//Space: O(H) recursion stack
//👉 Always initialize global max to Integer.MIN_VALUE.

//Pros
//No global variable — pure functions
//Easier to test, reuse, and reason about
//Fits functional programming style

//❌ Cons
//Slightly more verbose
//Need extra wrapper objects if multiple values are tracked
//Less common in competitive programming / interview style

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
package tree;


class MaximumSumPathLocal {
    class Result {
        int maxSum;
        Result(int maxSum) { this.maxSum = maxSum; }
    }

    private int dfs(TreeNode node, Result result) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left, result));
        int right = Math.max(0, dfs(node.right, result));
        result.maxSum = Math.max(result.maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        Result result = new Result(Integer.MIN_VALUE);
        dfs(root, result);
        return result.maxSum;
    }

}