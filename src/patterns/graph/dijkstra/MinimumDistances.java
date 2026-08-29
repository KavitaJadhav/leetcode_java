//https://www.scaler.com/academy/mentee-dashboard/class/514064/assignment/problems/4706?navref=cl_tt_nv
package patterns.graph.dijkstra;

import java.util.*;

public class MinimumDistances {
//    public class Solution {

    class Edge {
        public int node;
        public int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public ArrayList<Integer> solve(
            int nodes,
            ArrayList<ArrayList<Integer>> edges,
            int source) {

        Map<Integer, ArrayList<Edge>> map = new HashMap<>();

        for (int number = 0; number < nodes; number++) {
            map.put(number, new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {

            int node1 = edge.get(0);
            int node2 = edge.get(1);
            int distance = edge.get(2);

            map.get(node1).add(new Edge(node2, distance));
            map.get(node2).add(new Edge(node1, distance));
        }

        int[] distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        PriorityQueue<Edge> queue =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        distances[source] = 0;
        queue.offer(new Edge(source, 0));

        while (!queue.isEmpty()) {

            Edge edge = queue.poll();

            if (edge.distance > distances[edge.node])
                continue;

            for (Edge next : map.get(edge.node)) {

                int newDistance = edge.distance + next.distance;

                if (newDistance < distances[next.node]) {

                    distances[next.node] = newDistance;

                    queue.offer(
                            new Edge(next.node, newDistance)
                    );
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int index = 0; index < nodes; index++) {

            if (distances[index] == Integer.MAX_VALUE)
                result.add(-1);
            else
                result.add(distances[index]);
        }

        return result;
    }
}