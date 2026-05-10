//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//Complexity:
//Time  = O(n)
//Space = O(n)

package patterns.tree;

/**
 * Definition for a binary patterns.tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class SerializeDeserializeBFS {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.append("N,");
                continue;
            }

            result.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("N")) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            // left child
            if (!values[index].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.left);
            }
            index++;

            // right child
            if (!values[index].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(parent.right);
            }
            index++;
        }

        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));