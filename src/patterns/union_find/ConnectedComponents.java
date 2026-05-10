//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
//https://github.com/KavitaJadhav/data_structure_questions/blob/main/ds_patterns/union_find/connected_componenets.rb
//https://www.youtube.com/watch?v=8f1XPm4WOUc

//Final Time Complexity
//        With path compression + union by rank:
//        Time:  O(E * α(N))   (almost constant)
//        Space: O(N)
//        α(N) = inverse Ackermann function (~ < 5 in practice).

package patterns.union_find;

import java.util.*;

public class ConnectedComponents {
    private class UnionFind {
        Integer[] parent;
        Integer[] size;
        int connectedComponents;

        public UnionFind(int count) {
            this.parent = new Integer[count];
            this.size = new Integer[count];
            this.connectedComponents = count;

            for (int index = 0; index < count; index++) {
                parent[index] = index;
                size[index] = 1;
            }
        }

        public int find(Integer number) {
            if (parent[number] != number)
                parent[number] = find(parent[number]); //Implement path compression with recursion
            return parent[number];
        }

        public boolean union(Integer component1, Integer component2) {
            Integer component1Parent = find(component1);
            Integer component2Parent = find(component2);

            if (component1Parent == component2Parent) return false;

            if (this.size[component1Parent] > this.size[component2Parent]) {
                parent[component2Parent] = component1Parent;
                this.size[component1Parent]++;
            } else {
                parent[component1Parent] = component2Parent;
                this.size[component2Parent]++;
            }
            connectedComponents--;
            return true;
        }

        public int getConnectedComponents() {
            return this.connectedComponents;
        }
    }


    public int getConnectedComponents(List<List<Integer>> components, int count) {
        UnionFind unionFind = new UnionFind(count);
        for (List<Integer> component : components) {
            unionFind.union(component.get(0), component.get(1));
        }
        return unionFind.getConnectedComponents();
    }

    public static void main(String[] args) {
//        connected_components([[0, 1], [1, 2], [3, 4]], 5) == 2

        List<List<Integer>> components = new ArrayList<>();
        components.add(new ArrayList<>(Arrays.asList(0, 1)));
        components.add(new ArrayList<>(Arrays.asList(1, 2)));
        components.add(new ArrayList<>(Arrays.asList(3, 4)));
        ConnectedComponents connectedComponents = new ConnectedComponents();

        System.out.println(connectedComponents.getConnectedComponents(components, 5));
    }
}
