//Idle DFS
//BFS is better for shorter path
// DFS and BFS both work for reachability.
// BFS is useful when we need the shortest path in an unweighted graph.

//https://www.scaler.com/academy/mentee-dashboard/class/514057/homework/problems/516/hints?navref=cl_pb_nv_tb
//find whether you can reach the first town from the second without repeating any edge.
//B C : query to find whether B is reachable from C.

//Visisted is not needed as it's a directed grap and circles won't be formed as each element will point only to its parent
package patterns.graph.bfs;

import java.util.*;

public class TownsPath {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> towns, final int destination, final int source) {
        if (source == destination)
            return 1;
        Map<Integer, ArrayList<Integer>> adjecencyList = new HashMap<>();
        for (int vertex = 1; vertex <= towns.size(); vertex++) {
            adjecencyList.put(vertex, new ArrayList<>());
        }

        for (int index = 0; index < towns.size(); index++) {
            int parent = towns.get(index);
            int child = index + 1;

            if (parent != child) {
                adjecencyList.get(parent).add(child);
            }
        }

        Queue<Integer> queue = new LinkedList<>();


//        Set<Integer> visied = new HashSet<>();
//        visied.add(source);
        for (Integer edge : adjecencyList.get(source)) {
            queue.offer(edge);
        }

        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (next == destination)
                return 1;

            for (Integer edge : adjecencyList.get(next)) {
//                if (!visied.contains(edge)) {
                    queue.offer(edge);
//                    visied.add(edge);
//                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        TownsPath townsPath = new TownsPath();
        System.out.println(townsPath.solve(new ArrayList<>(Arrays.asList(1, 1, 2)), 1, 2));
        System.out.println(townsPath.solve(new ArrayList<>(Arrays.asList(1, 1, 2)), 2, 1));
        System.out.println(townsPath.solve(new ArrayList<>(Arrays.asList(1, 1, 2)), 1, 1));
        System.out.println(townsPath.solve(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 2)), 2, 3));
    }
}
//T = [1, 2 ,3]
//A = [1, 1, 2] - parents
//B = 1
//C = 2
//find C--->B possible?
//2--->1 - No
//1--->2 - Yes
//edges
//1->2->3

