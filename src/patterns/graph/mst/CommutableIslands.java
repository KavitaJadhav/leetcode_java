//https://www.scaler.com/academy/mentee-dashboard/class/514060/assignment/problems/376/?navref=cl_pb_nv_tb
//Todo: AI probing is pending
package patterns.graph.mst;

import java.util.*;

public class CommutableIslands {

    class Node{
        public int island;
        public int distance;

        public Node(int island, int distance){
            this.island= island;
            this.distance = distance;
        }

    }
    public int solve(int islands, ArrayList<ArrayList<Integer>> edges) {
        // Minimum spanning tree
        int cost = 0;
        int totalCost = 0;
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        for(int number = 1; number <= islands; number++){
            map.put(number, new ArrayList<>());
        }

        for(ArrayList<Integer> edge : edges){
            int from = edge.get(0);
            int to = edge.get(1);
            int weight = edge.get(2);
            map.get(from).add(new Node(to, weight));
            map.get(to).add(new Node(from, weight));
        }

        PriorityQueue<Node> queue= new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        for(Node node: map.get(1)){
            queue.offer(node);
        }

        Set<Integer> visitedIslands = new HashSet<>();
        visitedIslands.add(1);

        while(!queue.isEmpty()){
            Node next = queue.poll();

            if(!visitedIslands.contains(next.island)){
                totalCost+= next.distance;
                for(Node node : map.get(next.island)){
                    queue.offer(node);
                }
                visitedIslands.add(next.island);
            }
        }
        return totalCost;
    }
}
