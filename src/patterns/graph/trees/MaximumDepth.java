//https://www.scaler.com/academy/mentee-dashboard/class/514057/homework/problems/4357/submissions
// Primary pattern:    Tree Traversal / Level Order BFS
//Secondary pattern:    Preprocessing + Binary Search

//1. Build adjacency list
//↓
//2. Find level/depth of every node
//↓
//3. Group nodes by level
//↓
//4. Convert nodes → their values
//↓
//5. Sort values at each level
//↓
//6. For each query:
//level = L % (MaxDepth + 1)
//↓
//find smallest value >= X using binary search

//Todo: Reimplement to improve understanding
//Note: level order means think in term of bfs
package patterns.graph.trees;

public class MaximumDepth {


    public ArrayList<Integer> solve(
            int nodes,
            ArrayList<Integer> edgeFrom,
            ArrayList<Integer> edgeto,
            ArrayList<Integer> NodeValue,
            ArrayList<Integer> L,
            ArrayList<Integer> X) {

        // Build adjacency list
        Map<Integer, ArrayList<Integer>> edegMap = new HashMap<>();

        for (int node = 1; node <= nodes; node++) {
            edegMap.put(node, new ArrayList<>());
        }

        for (int index = 0; index < edgeFrom.size(); index++) {
            int from = edgeFrom.get(index);
            int to = edgeto.get(index);

            edegMap.get(from).add(to);
            edegMap.get(to).add(from);
        }

        // BFS and create level map
        Map<Integer, ArrayList<Integer>> levelMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(1);
        set.add(1);

        int lastLevel = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            levelMap.put(lastLevel, new ArrayList<>());

            for (int index = 0; index < size; index++) {

                int node = queue.poll();

                levelMap.get(lastLevel).add(node);

                for (Integer value : edegMap.get(node)) {

                    if (!set.contains(value)) {
                        set.add(value);
                        queue.offer(value);
                    }
                }
            }

            lastLevel++;
        }

        // Convert node levels into node values
        Map<Integer, ArrayList<Integer>> valueMap = new HashMap<>();

        for (Integer key : levelMap.keySet()) {

            ArrayList<Integer> list = new ArrayList<>();

            for (Integer node : levelMap.get(key)) {
                list.add(NodeValue.get(node - 1));
            }

            Collections.sort(list);
            valueMap.put(key, list);
        }

        // Answer queries
        ArrayList<Integer> result = new ArrayList<>();

        int maxDepth = lastLevel - 1;

        for (int index = 0; index < L.size(); index++) {

            int requiredLevel = L.get(index) % (maxDepth + 1);

            ArrayList<Integer> list = valueMap.get(requiredLevel);

            result.add(
                    getMinGreaterOrEqual(list, X.get(index))
            );
        }

        return result;
    }

    private int getMinGreaterOrEqual(
            ArrayList<Integer> list,
            int x) {

        int index = Collections.binarySearch(list, x);

        if (index < 0) {
            index = -index - 1;
        }

        if (index == list.size()) {
            return -1;
        }

        return list.get(index);
    }
}