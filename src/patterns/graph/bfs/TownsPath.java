//Idle DFS
//BFS is better for shorter path
//https://www.scaler.com/academy/mentee-dashboard/class/514057/homework/problems/516/hints?navref=cl_pb_nv_tb
 package patterns.graph.bfs;

import java.util.*;

public class TownsPath {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> towns, final int destination, final int source) {
        if (source == destination)
            return 1;
        Map<Integer, ArrayList<Integer>> adjecencyList = new HashMap<>();
        for(int vertex = 1; vertex <= towns.size(); vertex++ ){
            adjecencyList.put(vertex, new ArrayList<>());
        }

        for(int index = 0; index <towns.size(); index++ ){
            adjecencyList.get(towns.get(index)).add(index+1);
        }

        Queue<Integer> queue = new LinkedList<>();


        Set<Integer> visied = new HashSet<>();
        visied.add(source);
        for(Integer edge : adjecencyList.get(source)){
            queue.offer(edge);
        }

        while(!queue.isEmpty()){
            int next = queue.poll();
            if(next==destination)
                return 1;

            for(Integer edge : adjecencyList.get(next)){
                if(!visied.contains(edge))
                    queue.offer(edge);
            }
        }

        return 0;
    }
}

