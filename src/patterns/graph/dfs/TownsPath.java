//Idle DFS
//Todo: implement again and submit dfs approach.. copied code for reference
//https://www.scaler.com/academy/mentee-dashboard/class/514057/homework/problems/516/hints?navref=cl_pb_nv_tb
package patterns.graph.dfs;

import java.util.*;

public class TownsPath {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> towns,
                     final int destination,
                     final int source) {

        Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

        for (int vertex = 1; vertex <= towns.size(); vertex++) {
            adjacencyList.put(vertex, new ArrayList<>());
        }

        // A[i] -> i + 1
        // A[0] is ignored
        for (int index = 1; index < towns.size(); index++) {
            int from = towns.get(index);
            int to = index + 1;

            adjacencyList.get(from).add(to);
        }

        Set<Integer> visited = new HashSet<>();

        if (dfs(source, destination, adjacencyList, visited)) {
            return 1;
        }

        return 0;
    }

    private boolean dfs(int current,
                        int destination,
                        Map<Integer, ArrayList<Integer>> adjacencyList,
                        Set<Integer> visited) {

        if (current == destination) {
            return true;
        }

        visited.add(current);

        for (Integer edge : adjacencyList.get(current)) {

            if (!visited.contains(edge)) {

                if (dfs(edge, destination, adjacencyList, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}

