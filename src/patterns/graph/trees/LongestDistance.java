//https://www.scaler.com/academy/mentee-dashboard/class/514064/homework/problems/369/submissions

package patterns.graph.trees;

import java.util.*;

public class LongestDistance {

    class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int solve(ArrayList<Integer> parents) {
        if (parents.size() <= 1)
            return 0;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int index = 0; index < parents.size(); index++) {
            int parent = parents.get(index);

            if (parent == -1)
                continue;


// tree need to store information of two way edge
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(index);
            map.computeIfAbsent(index, k -> new ArrayList<>()).add(parent);
        }


        int[] distances = new int[parents.size()];
        boolean[] visited = new boolean[parents.size()];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        distances[0] = 0;
        visited[0] = true;


        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int neighbour : map.get(node.node)) {
                int newDistance = node.distance + 1;
                if (!visited[neighbour]) {
                    queue.offer(new Node(neighbour, newDistance));
                    distances[neighbour] = newDistance;
                    visited[neighbour]=true;
                }
            }
        }

        int maxIndex = 0;
        for (int index = 0; index < distances.length; index++) {
            if (distances[index] > distances[maxIndex]) {
                maxIndex = index;
            }
        }

        Arrays.fill(distances, 0);
        Arrays.fill(visited, false);
        queue.offer(new Node(maxIndex, 0));
        distances[maxIndex] = 0;
        visited[maxIndex] = true;


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int neighbour : map.get(node.node)) {
                int newDistance = node.distance + 1;
                if (!visited[neighbour]) {
                    queue.offer(new Node(neighbour, newDistance));
                    distances[neighbour] = newDistance;
                    visited[neighbour]=true;
                }
            }
        }

        int maxDiameter = 0;
        for (int index = 1; index < distances.length; index++) {
            if (distances[index] > maxDiameter) {
                maxDiameter = distances[index];
            }
        }
        return maxDiameter;
    }

    public static void main(String[] args) {
        LongestDistance longestDistance = new LongestDistance();
        System.out.println(longestDistance.solve(new ArrayList<>(List.of(-1,0,0,0,3))));
    }
}
