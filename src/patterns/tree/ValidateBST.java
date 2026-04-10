//https://leetcode.com/problems/validate-binary-search-tree/description/
package patterns.tree;

//| DFS Type  | Time Complexity | Space Complexity |
//| --------- | --------------- | ---------------- |
//| Recursive | O(N)            | O(H)             |
//| Iterative | O(N)            | O(H)             |


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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    public TreeNode() {
    }

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

class ValidateBST {
    private boolean validate(TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        if (node.val <= minValue || node.val >= maxValue) return false;
        return validate(node.left, minValue, node.val) && validate(node.right, node.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}