//# https://www.youtube.com/watch?v=ScvTcU2Aifs
//# https://leetcode.com/problems/maximum-depth-of-binary-tree
//# Definition for a binary patterns.tree node.
//# Given the root of a binary patterns.tree, return its maximum depth.
//# A binary patterns.tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//

package patterns.tree;


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
class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}