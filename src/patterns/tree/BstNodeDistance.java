package patterns.tree;

public class BstNodeDistance {

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
    public int solve(TreeNode root, int value1, int value2) {
        return distance(root, value1, value2);
    }
    private int distance(TreeNode node, int value1, int value2){
        if(value1 < node.val && value2< node.val)
            return distance(node.left, value1, value2);
        if(value1 > node.val && value2> node.val)
            return distance(node.right, value1, value2);
        return height(node,value1)+ height(node, value2);
    }

    private int height(TreeNode node, int value){
        if(value == node.val)
            return 0;
        else if(value < node.val)
            return height(node.left, value)+1;
        else
            return height(node.right, value)+1;
    }
}
