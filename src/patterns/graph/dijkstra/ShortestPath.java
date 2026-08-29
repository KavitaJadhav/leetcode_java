//https://www.scaler.com/academy/mentee-dashboard/class/514064/assignment/problems/4707?navref=cl_tt_nv
package patterns.graph.dijkstra;

import java.util.*;

public class ShortestPath {
    class Edge {
        public int node, to, distance;

        public Edge(int node, int distance) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int solve(int nodes, ArrayList<ArrayList<Integer>> edges, int source, int target) {
        Map<Integer, ArrayList<Edge>> map = new HashMap<>();

        int[] distances = new int[nodes];
        Arrays.fill(distances, Integer.MAX_VALUE);

        for (int number = 0; number < nodes; number++) {
            map.put(number, new ArrayList<>());
        }

        for (int index = 0; index < edges.size(); index++) {
            int node1 = edges.get(index).get(0);
            int node2 = edges.get(index).get(1);
            int distance = edges.get(index).get(2);

            map.get(node1).add(new Edge(node2, distance));
            map.get(node2).add(new Edge(node1, distance));
        }

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        queue.offer(new Edge(source, 0));
        distances[source] = 0;

        while (!queue.isEmpty()) {

            Edge edge = queue.poll();
            if (edge.distance > distances[edge.node])
                continue;

            if (edge.node == target)
                return edge.distance;

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
        return -1;
    }

}
