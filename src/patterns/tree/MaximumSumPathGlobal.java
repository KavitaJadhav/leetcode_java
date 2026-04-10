//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
// 📊 Complexity
//
//Time: O(N)
//Space: O(H) recursion patterns.stack
//👉 Always initialize global max to Integer.MIN_VALUE.

//✅ Pros
//Very clean for DFS problems where parent needs info from children
//No need to pass extra parameters around
//Easy to read, short code
//Works well for problems like Binary Tree Maximum Path Sum
//
//❌ Cons
//Less “pure” — function depends on outside state
//Harder to reuse DFS in other contexts
//Can break if you reuse the same Solution object

/**
 * Definition for a binary patterns.tree node.
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
package patterns.tree;

class MaximumSumPathGlobal {
    int maxSum = Integer.MIN_VALUE;

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (node.val > maxSum) maxSum = node.val;
            return node.val;
        }
        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));

        int currentSum = leftSum + rightSum + node.val;
        if (currentSum > maxSum) maxSum = currentSum;
        return Math.max(leftSum, rightSum) + node.val;
    }


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }


}