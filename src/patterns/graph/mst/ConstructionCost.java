//https://www.scaler.com/academy/mentee-dashboard/class/514060/assignment/problems/9240/?navref=cl_pb_nv_tb

//Todo: AI probing is pending
package patterns.graph.mst;

import java.util.*;

public class ConstructionCost {

    class Node{
        public int center;
        public int distance;

        public Node(int center, int distance){
            this.center= center;
            this.distance = distance;
        }

    }
    public int solve(int centers, ArrayList<ArrayList<Integer>> edges) {
        // Minimum spanning tree
        int cost = 0;
        int totalCost = 0;
        int mod = 1000000007;
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        for(int number = 1; number <= centers; number++){
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

        Set<Integer> visitedcenters = new HashSet<>();
        visitedcenters.add(1);

        while(!queue.isEmpty()){
            Node next = queue.poll();

            if(!visitedcenters.contains(next.center)){
                totalCost+= next.distance;
                totalCost%=mod;
                for(Node node : map.get(next.center)){
                    queue.offer(node);
                }
                visitedcenters.add(next.center);
            }
        }
        return totalCost;
    }
}

