package mock_practice;

import java.util.ArrayDeque;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class LevelDifference {

    public int levelDifference(TreeNode root) {
        if (root == null)
            return 0;

        int oddSum = 0;
        int evenSum = 0;

        boolean isOdd = true; // start with level 1 (odd)

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (isOdd)
                    oddSum += node.val;
                else
                    evenSum += node.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            isOdd = !isOdd; // flip after each level
        }

        return oddSum - evenSum;
    }
}