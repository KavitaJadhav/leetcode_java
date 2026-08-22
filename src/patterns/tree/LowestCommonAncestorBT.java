//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
package patterns.tree;

public class LowestCommonAncestorBT {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    Node root;

    public void add(int value) {
//        Todo: Simplify logic.
        Node node = new Node(value);
        if (isEmpty()) {
            this.root = node;
        } else {
            add(root, node);
        }
    }

    private void add(Node parent, Node new_node) {
        if (new_node.value < parent.value) {
            if (parent.left == null) {
                parent.left = new_node;
            } else {
                add(parent.left, new_node);
            }
        } else {
            if (parent.right == null) {
                parent.right = new_node;
            } else {
                add(parent.right, new_node);
            }

        }
    }

    //Time Complexity = O(h)
    //                 = O(log n) for balanced BST
    //                 = O(n) for skewed BST
//
//    Space Complexity = O(h) for recursion
//                 = O(1) for iterative solution
    boolean value1Found = false;
    boolean value2Found = false;

    public int lowestCommonAncestor(TreeNode root, int value1, int value2) {
        value1Found = false;
        value2Found = false;

        if(root==null )
            return -1;

        TreeNode result = search(root, value1, value2);
        if(result==null )
            return -1;

        if(value1Found==false || value2Found==false )
            return -1;

        return result.val;
    }

    private TreeNode search(TreeNode node, int value1, int value2){
        if(node==null)
            return node;

        if(node.val==value1 && node.val==value2){
            value1Found=true;
            value2Found=true;
            return node;
        }

        if(node.val==value1)
            value1Found=true;

        if(node.val==value2)
            value2Found=true;


        TreeNode left = search(node.left, value1, value2);
        TreeNode right = search(node.right, value1, value2);

        if(left!=null && right!=null)
            return node;

        if(node.val==value1 || node.val==value2)
            return node;

        return left!=null ? left : right;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBT tree = new LowestCommonAncestorBT();
    }
}

//Time: O(N) (you visit every node)
//Space: O(H) recursion stack
//This version correctly handles:
//
//LCA(33,5) -> 5
//LCA(4,5)  -> 2
//LCA(4,6)  -> -1
//LCA(4,3)  -> 1
//LCA(7,8)  -> -1
//LCA(1,1)  -> 1
