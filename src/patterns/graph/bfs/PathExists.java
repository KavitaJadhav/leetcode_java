
//https://www.scaler.com/academy/mentee-dashboard/class/514057/assignment/problems/9359/submissions
package patterns.graph.bfs;
//Given a directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
//B[i][0] to node B[i][1].
//Find whether a path exists from node 1 to node A.

import java.util.*;
public class PathExists {

    public int solve(int nodes, ArrayList<ArrayList<Integer>> matrix) {
        Map<Integer, ArrayList<Integer>> adjecencyList = new HashMap<>();
        for(int vertex = 1; vertex <= nodes; vertex++ ){
            adjecencyList.put(vertex, new ArrayList<>());
        }

        for(ArrayList<Integer> pair :  matrix){
            int edgeFrom = pair.get(0);
            int edgeTo = pair.get(1);
            adjecencyList.get(edgeFrom).add(edgeTo);
        }

        Queue<Integer> queue = new LinkedList<>();


        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        for(Integer edge : adjecencyList.get(1)){
            queue.offer(edge);
        }

        while(!queue.isEmpty()){
            int next = queue.poll();
            if(next==nodes)
                return 1;

            for(Integer edge : adjecencyList.get(next)){
                if(!visited.contains(edge))
                    queue.offer(edge);
            }
        }

        return 0;
    }
}
