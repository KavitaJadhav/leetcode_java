package patterns.tree;

//Note - this solution works for complete tree.
//Todo -  check if this work for noncomplete tree

public class SetNextPointer {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     * int val;
     * TreeLinkNode left, right, next;
     * TreeLinkNode(int x) { val = x; }
     * }
     */
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();

        queue.offer(root);
        TreeLinkNode previous = null;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 1; count <= size; count++) {
                TreeLinkNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);

                if (count != 1) {
                    previous.next = node;
                }

                previous = node;
            }
        }
    }
}
