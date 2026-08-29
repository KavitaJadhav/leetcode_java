//https://www.scaler.com/academy/mentee-dashboard/class/514064/assignment/problems/9328/?navref=cl_pb_nv_tb
package patterns.graph.topological_sort;

import java.util.*;

public class TopologicalLexicographicalOrder {
    //public class Solution {
// map
// indegree
// queue enter 0 indegree
// queue while loop
// result
    public ArrayList<Integer> solve(int nodes, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] indegree = new int[nodes + 1];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int node = 1; node <= nodes; node++) {
            map.put(node, new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            map.get(edge.get(0)).add(edge.get(1));
            indegree[edge.get(1)]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();

        for (int index = 1; index <= nodes; index++) {
            if (indegree[index] == 0) {
                queue.offer(index);
            }

        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (Integer neighbour : map.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }


        for (int index = 1; index <= nodes; index++) {
            if (indegree[index] > 0)
                return new ArrayList<>();
        }
        return result;
    }
}

