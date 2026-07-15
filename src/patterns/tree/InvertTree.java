//  https://leetcode.com/problems/invert-binary-tree/
// https://www.youtube.com/watch?v=ScvTcU2Aifs
// https://leetcode.com/problems/invert-binary-tree for a binary patterns.tree node.
//
//         Complexity
// Time - o(n)
// Space - recursion patterns.stack o(log n)...o(n) if one side patterns.tree
//
//        
package patterns.tree;

/**
 * Definition for a binary patterns.tree node.
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

//class InvertTree {
//    public TreeNode invertTree(TreeNode node) {
//        if(node==null) return null;
//
//        node.right = invertTree(node.left); //This will not work as the reference of right will be updated before its used in the next line
//        node.left = invertTree(node.right);
//        return node;
//    }
//}

//
// iterative
// Space O(1) - recursion patterns.stack avoided, but queue intruduced
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