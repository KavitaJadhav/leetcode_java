package patterns.tree;

import java.util.Stack;

public class CommonSumNodeBST {
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
    public int solve(TreeNode root1, TreeNode root2) {
        int sum= 0;
        int mod = 1000000007;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        push(root1, stack1);
        push(root2, stack2);

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek().val == stack2.peek().val){
                sum+=stack1.peek().val;
                sum%=mod;
                pop(stack1);
                pop(stack2);
            }else if(stack1.peek().val < stack2.peek().val){
                pop(stack1);
            }else{
                pop(stack2);
            }
        }
        return sum;
    }

    private void push(TreeNode node, Stack<TreeNode> stack){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }
    private int pop(Stack<TreeNode> stack){
        TreeNode node = stack.pop();
        push(node.right, stack);
        return node.val;
    }
}

