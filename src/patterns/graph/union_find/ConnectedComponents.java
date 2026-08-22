//https://www.scaler.com/academy/mentee-dashboard/class/514057/assignment/problems/272002?navref=cl_tt_nv
package patterns.graph.union_find;

import java.util.*;

public class ConnectedComponents {

    class UnionFind {
        public int componenets;

        public int[] parent;
        public int[] size;


        public UnionFind(int componenets) {
            this.componenets = componenets;
            parent = new int[componenets];
            size = new int[componenets];

            for (int index = 0; index < componenets; index++) {
                parent[index] = index;
                size[index] = 1;
            }
        }

        public void union(int from, int to) {
            int parent1 = find(from);
            int parent2 = find(to);
            if (parent1 == parent2)
                return;

            if (size[parent1] >= size[parent2]) {
                parent[parent2] = parent1;
                size[parent2] +=1;
            }
            else {
                parent[parent1] = parent2;
                size[parent1] +=1;
            }
            componenets--;
        }

        public int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }

            return parent[vertex];
        }
    }

    public ArrayList<ArrayList<Integer>> getComponents(int nodes, ArrayList<ArrayList<Integer>> edges) {

        UnionFind unionFind = new UnionFind(nodes);

        for (ArrayList<Integer> edge : edges) {
            unionFind.union(edge.get(0), edge.get(1));
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int index = 0; index < nodes; index++) {
            int parent = unionFind.find(index);
            if (!map.containsKey(parent))
                map.put(parent, new ArrayList<>());
            map.get(parent).add(index);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
            result.add(list);        }

        Collections.sort(result, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        return result;
    }
}
