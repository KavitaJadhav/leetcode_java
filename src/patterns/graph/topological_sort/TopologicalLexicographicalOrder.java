//https://www.scaler.com/academy/mentee-dashboard/class/514064/assignment/problems/9328/?navref=cl_pb_nv_tb
package patterns.graph.topological_sort;
//Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//Return the topological ordering of the graph and if it doesn't exist then return an empty array.
//If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
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
// PriorityQueue is used instead LinkedList to ensure Topological ordering
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

