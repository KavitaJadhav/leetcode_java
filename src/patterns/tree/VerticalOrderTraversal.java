package patterns.tree;

import java.nio.channels.Pipe;
import java.util.*;

public class VerticalOrderTraversal {
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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversalBfs(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, map, 0);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            // ArrayList<Integer> levelValues =
            // System.out.print(" "+key);
            result.add(new ArrayList<>(map.get(key)));
        }

        return result;
    }

    class Pair {
        TreeNode node;
        Integer level;

        public Pair(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversalDfs(TreeNode root) {
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


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            result.add(new ArrayList<>(map.get(key)));
        }

        return result;
    }

    private void dfs(TreeNode node, Map<Integer, List<Integer>> map, int val) {
        if (node == null)
            return;

        map.putIfAbsent(val, new ArrayList<>());
        map.get(val).add(node.val);

        dfs(node.left, map, val - 1);
        dfs(node.right, map, val + 1);
    }

    public static void main(String[] args) {
//        VerticalOrderTraversal tree = new VerticalOrderTraversal();
//        TreeNode root = new TreeNode(3709);
//        root.left = new TreeNode(4465);
//        root.right = new TreeNode(2668);
//        System.out.println(tree.verticalOrderTraversalDfs(root));
//
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        TreeNode root = new TreeNode(3709);
        root.left = new TreeNode(4465);
        root.right = new TreeNode(2668);
        System.out.println(tree.verticalOrderTraversalDfs(root));
    }
}
