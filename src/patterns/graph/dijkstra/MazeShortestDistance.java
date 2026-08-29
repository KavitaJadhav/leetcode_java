//https://www.scaler.com/academy/mentee-dashboard/class/514072/assignment/problems/4697/submissions
 package patterns.graph.dijkstra;

import java.util.*;

public class MazeShortestDistance {

    class Node{
        public int row;
        public int column;
        public int distance;

        public Node(int row, int column, int distance){
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> maze, ArrayList<Integer> source, ArrayList<Integer> target) {
        int rows = maze.size();
        if(rows==0)
            return 0;

        int columns = maze.get(0).size();

        int[][] distances = new int[rows][columns];
        for(int index = 0; index < rows;index++){
            Arrays.fill(distances[index], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a-> a.distance));
        queue.offer(new Node(source.get(0), source.get(1) , 0));
        distances[source.get(0)][source.get(1)] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            int[][] neighbours = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

            for(int[] n: neighbours){
                int currentRow = node.row;
                int currentColumn = node.column;
                int count=0;
                while(currentRow + n[0]>=0 &&
                        currentRow+ n[0]<rows &&
                        currentColumn+ n[1]>=0
                        && currentColumn+ n[1]<columns
                        && maze.get(currentRow+n[0]).get(currentColumn+n[1])!=1){
                    currentRow+=n[0];
                    currentColumn+=n[1];
                    count++;
                }

                if(node.distance+count < distances[currentRow][currentColumn]){
                    distances[currentRow][currentColumn] = node.distance + count;
                    queue.offer(new Node(currentRow,currentColumn, node.distance+count));
                }

            }
        }
        if(distances[target.get(0)][target.get(1)] == Integer.MAX_VALUE)
            return -1;

        return distances[target.get(0)][target.get(1)] ;
    }
}


// A = [ [0, 0],
//       [0, 0] ]
// B = [0, 0]
// C = [0, 1]