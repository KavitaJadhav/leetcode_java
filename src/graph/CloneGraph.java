//https://leetcode.com/problems/clone-graph/
//🧠 Complexity
//
//Let:
//
//V = number of nodes
//
//        E = number of edges
//
//Time: O(V + E)
//Each node and edge visited once.
//
//Space: O(V)
//
//HashMap stores all nodes
//
//Recursion stack up to V
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

package graph;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) return null ;
        Map<Node, Node> clonedMap = new HashMap(){};
        return dfsClone(node, clonedMap);
    }

    private Node dfsClone(Node node, Map<Node, Node> clonedMap){

        if ( clonedMap.containsKey(node)) {
            return clonedMap.get(node);
        };

        Node clone = new Node(node.val);
        clonedMap.put(node, clone);

        for(Node neighbor : node.neighbors) {
            clone.neighbors.add(dfsClone(neighbor, clonedMap));
        }
        return clone;
    }
}
