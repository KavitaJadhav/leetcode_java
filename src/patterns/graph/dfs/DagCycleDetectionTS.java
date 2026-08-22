//https://www.scaler.com/academy/mentee-dashboard/class/514057/assignment/problems/9327/?navref=cl_pb_nv_tb
package patterns.graph.dfs;
//Todo: copied code.. Understand and solve again. Tradeoffs

import java.util.*;
public class DagCycleDetectionTS {

    public ArrayList<Integer> topologicalSort(
            int nodes,
            ArrayList<ArrayList<Integer>> matrix) {

        // 1. Build adjacency list
        Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        for (int vertex = 1; vertex <= nodes; vertex++) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        // 2. Calculate indegree
        int[] indegree = new int[nodes + 1];

        for (ArrayList<Integer> edge : matrix) {
            int from = edge.get(0);
            int to = edge.get(1);

            adjacencyList.get(from).add(to);
            indegree[to]++;
        }

        // 3. Put nodes with indegree 0 into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int vertex = 1; vertex <= nodes; vertex++) {
            if (indegree[vertex] == 0) {
                queue.add(vertex);
            }
        }

        // 4. Process nodes
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int vertex = queue.poll();
            result.add(vertex);

            for (Integer neighbor : adjacencyList.get(vertex)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 5. If not all nodes processed → cycle
        if (result.size() != nodes) {
            return new ArrayList<>(); // cycle exists
        }

        return result;
    }
}

// {1=[4, 5, 3], 2=[1, 3, 4, 5], 3=[1, 4, 5, 2], 4=[3, 5, 2, 1], 5=[3, 1, 4, 2]}0


//  A = 5
//  B = [  [1, 2]
//         [4, 1]
//         [2, 4]
//         [3, 4]
//         [5, 2]
//         [1, 3] ]