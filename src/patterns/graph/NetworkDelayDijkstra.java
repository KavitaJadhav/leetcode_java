//https://leetcode.com/problems/network-delay-time/
//Summary
//Algorithm: Dijkstra
//Time: O(E log V)
//Space: O(V + E)
//Pattern: Graph + Min Heap

package patterns.graph;

import java.util.*;

public class NetworkDelayDijkstra {
    private static class Edge {
        int node, distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] edges, int nodes, int startNode) {

        Map<Integer, List<Edge>> adjacencyMap = new HashMap<>();
        for (int node = 1; node <= nodes; node++) {
            adjacencyMap.put(node, new ArrayList<>());
        }
        for (int index = 0; index < edges.length; index++) {
            int[] edge = edges[index];
            adjacencyMap.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.distance));
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        Map<Integer, Integer> distancemap = new HashMap<>();

        for (int node = 1; node <= nodes; node++) {
            distancemap.put(node, Integer.MAX_VALUE);
        }

        priorityQueue.offer(new Edge(startNode, 0));
        distancemap.put(startNode, 0);

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            if (visited.contains(current.node)) continue;

            visited.add(current.node);

            for (Edge edge : adjacencyMap.get(current.node)) {
                int new_distance;
                new_distance = edge.distance + current.distance;
                if (new_distance < distancemap.get(edge.node)) {
                    distancemap.put(edge.node, new_distance);
                    priorityQueue.offer(new Edge(edge.node, new_distance));
                }
            }
        }

        int shortDistanceToAllNodes = 0;

        for (int node = 1; node <= nodes; node++) {
            if (distancemap.get(node) == Integer.MAX_VALUE) return -1;
            shortDistanceToAllNodes = Math.max(shortDistanceToAllNodes, distancemap.get(node));
        }
        return shortDistanceToAllNodes;
    }


    public static void main(String[] args) {
        NetworkDelayDijkstra networkDelayDijkstra = new NetworkDelayDijkstra();
        int[][] edges = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(networkDelayDijkstra.networkDelayTime(edges, 4, 2));
    }
}
