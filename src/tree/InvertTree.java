//  https://leetcode.com/problems/invert-binary-tree/
// https://www.youtube.com/watch?v=ScvTcU2Aifs
// https://leetcode.com/problems/invert-binary-tree for a binary tree node.
//
//         Complexity
// Time - o(n)
// Space - recursion stack o(log n)...o(n) if one side tree
//
//        
package tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class InvertTree {
    public TreeNode invertTree(TreeNode node) {
        if(node==null) return null;
        invertTree(node.left);
        invertTree(node.right);

        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        return node;
    }
}
//
// iterative
// Space O(1) - recursion stack avoided, but queue intruduced
//def invert_tree_iterative(root)
//return nil if root.nil?
//
//queue = [root]
//
//until queue.empty?
//node = queue.shift
// swap left and right safely
//node.left, node.right = node.right, node.left
//
// enqueue children if not nil
//queue << node.left if node.left
//queue << node.right if node.right
//end
//
//root
//end