//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
package patterns.tree;

public class LowestCommonAncestorBST {
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
    public Node lowestCommonAncestor(int value1, int value2) {
//        Todo: implement iterative solution too
        if (this.isEmpty()) {
            return null;
        }
        return lowestCommonAncestor(root, value1, value2);
    }

    private Node lowestCommonAncestor(Node node, int value1, int value2) {
        if (value1 < node.value && value2 < node.value) {
            return lowestCommonAncestor(node.left, value1, value2);
        }

        if (value1 > node.value && value2 > node.value) {
            return lowestCommonAncestor(node.right, value1, value2);
        }
        return node;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
        tree.add(40);
        tree.add(30);
        tree.add(50);
        tree.add(20);
        tree.add(10);
        tree.add(60);
        tree.add(70);

        System.out.println("60, 70 :" + tree.lowestCommonAncestor(60, 70).getValue());
        System.out.println("30, 50 :" + tree.lowestCommonAncestor(30, 50).getValue());
        System.out.println("30, 20 :" + tree.lowestCommonAncestor(30, 20).getValue());
    }
}

