////{2, 1, 1},
////{2, 3, 1},
////{3, 4, 1}
////k = 2
////n = 4
//
//import java.util.HashSet;
//import java.util.Queue;
//
//public int maxPath(int[][] edge, int n, int k) {
//    class Edge {
//        int vertex;
//        int distance;
//    }
//    Map<Integer, List<Edge>> adjacencyMap = new Hashmap<>();
//    Set<Integer> visited = new HashSet<>();
//    Map<Integer, Integer> distanceMap = new Hashmap<>();
//
//    for (int index = 1; index <= n; index++) {
//        adjacencyMap.put(index, new ArrayList<>());
//        distanceMap.put(index, Integer.MAX_VALUE);
//
//    }
//
//    for (int[] edge : edges) {
//        adjacencyMap.get(edge[0]).add(new Edge(edge[1], edge[2]));
//    }
//
//    PriorityQueue<Edge> queue = new PriorityQueue<>((edge1, edge2) -> {
//        edge1.distance - edge2.distance
//    });
//
//    queue.add(new Edge(k, 0));
//
//    distanceMap.put(k, 0);
//
//    while (!queue.isEmpty()) {
//        Edge egde = Queue.poll;
//        if(visited.include(edge.vertex))
//            continue;
//        visited.add(edge.vertex);
//
//        if(distanceMap.get(edge.vertex) >  edge.distance)
//           distanceMap.put(edge.verted, edge.distance);
//
//        for(Edge neighbour : adjecencyMap.get(edge.vertex)){
//            queue.offer(new Edge(neighbour.vertex, neighbour.distance+edge.distance));
//        }
//    }
//
//    int minDistance  = Integer.MAX_VALUE;
//    for(int index = 1; index<=n; index++){
//        if(distanceMap.get(index)== Integer.MAX_VALUE)
//            return -1;
//
//    }
//}