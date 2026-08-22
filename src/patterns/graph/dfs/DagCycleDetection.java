//https://www.scaler.com/academy/mentee-dashboard/class/514057/assignment/problems/9327/?navref=cl_pb_nv_tb
package patterns.graph.dfs;

import java.util.*;
public class DagCycleDetection {

    public int solve(int nodes, ArrayList<ArrayList<Integer>> matrix) {
        // adjency list
        // each node - dfs,
        Map<Integer, ArrayList<Integer>> adjecencyList = new HashMap<>();
        for(int vertex = 1; vertex <= nodes; vertex++ ){
            adjecencyList.put(vertex, new ArrayList<>());
        }

        for(ArrayList<Integer> pair :  matrix){
            int edgeFrom = pair.get(0);
            int edgeTo = pair.get(1);
            adjecencyList.get(edgeFrom).add(edgeTo);
        }

        Set<Integer> visisting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        // System.out.print(adjecencyList);

        for(int vertex= 1; vertex <= nodes ; vertex++){
            if(dfs(vertex, visited,visisting, adjecencyList)==false){
                return 1;
            }
        }

        return 0;
    }

    private boolean dfs(int vertex, Set<Integer> visited, Set<Integer> visisting, Map<Integer, ArrayList<Integer>> adjecencyList){
        // System.out.print(vertex);
        // System.out.print(visisting);
        if(visited.contains(vertex)==true)
            return true;

        // System.out.print(visisting.contains(vertex) + " ");

        if(visisting.contains(vertex)==true)
            return false;

        visisting.add(vertex);
        for(Integer edge: adjecencyList.get(vertex)){
            if(dfs(edge, visited,visisting, adjecencyList)==false)
                return false;
        }

        visited.add(vertex);
        visisting.remove(vertex);

        return true;
    }
}
// {1=[4, 5, 3], 2=[1, 3, 4, 5], 3=[1, 4, 5, 2], 4=[3, 5, 2, 1], 5=[3, 1, 4, 2]}0


//  A = 5
//  B = [  [1, 2]
//         [4, 1]
//         [2, 4]
//         [3, 4]
//         [5, 2]
//         [1, 3] ]