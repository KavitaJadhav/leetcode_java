//https://leetcode.com/problems/diameter-of-binary-tree/
// Complexity
//Time Complexity: O(N)
//Each node is visited exactly once.
//
//Space Complexity: O(H)
//Recursive patterns.stack height.
//Worst case (skewed patterns.tree): O(N)
//Balanced patterns.tree: O(log N)

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
public class Diameter {
    int maxDiameter = 0;

    private int diameter(TreeNode node) {
        if (node == null) return 0;
        int left = diameter(node.left);
        int right = diameter(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return (Math.max(left, right) + 1);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        diameter(root);
        return maxDiameter;

    }
}
