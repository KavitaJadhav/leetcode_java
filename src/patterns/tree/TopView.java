package patterns.tree;

import java.util.*;

public class TopView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    class Pair {
        TreeNode node;
        Integer level;

        public Pair(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<Integer> solve(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            map.putIfAbsent(pair.level, new ArrayList<>());
            TreeNode node = pair.node;
            map.get(pair.level).add(node.val);

            if (node.left != null)
                queue.offer(new Pair(node.left, pair.level - 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, pair.level + 1));
        }

        ArrayList<Integer> result = new ArrayList<>();

        int minKey = Collections.min(map.keySet());
        int maxKey = Collections.max(map.keySet());

        for (int level = minKey; level <= maxKey; level++) {
            result.add(map.get(level).get(0));
        }

        return result;
    }

    public static void main(String[] args) {
        TopView tree = new TopView();
        TreeNode root = new TreeNode(3709);
        root.left = new TreeNode(4465);
        root.right = new TreeNode(2668);
        System.out.println(tree.solve(root));
    }
}
