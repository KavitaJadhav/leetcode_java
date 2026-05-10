//Difference Between Sum of Odd Levels and Even Levels in a Binary Tree
//Time: O(n) (visit each node once)
//Space:
//BFS → O(n) (queue)
//DFS → O(h) (recursion stack)
package mock_practice;

class TreeLevelSumDiff {
    public int differenceOfSums(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int oddSum = 0;
        int evenSum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (level % 2 == 1) {
                oddSum += levelSum;
            } else {
                evenSum += levelSum;
            }

            level++;
        }

        return oddSum - evenSum;
    }
}
class TreeLevelSumDiffDFS {
    public int differenceOfSums(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs(TreeNode node, int level) {
        if (node == null) return 0;

        if (level % 2 == 1) {
            return node.val + dfs(node.left, level + 1) + dfs(node.right, level + 1);
        } else {
            return -node.val + dfs(node.left, level + 1) + dfs(node.right, level + 1);
        }
    }
}