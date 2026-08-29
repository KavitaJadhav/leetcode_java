//https://www.scaler.com/academy/mentee-dashboard/class/514060/assignment/problems/4704/submissions
// Todo: AI probing is pending

package patterns.graph.bfs;

import java.util.*;

public class RottonOranges {

    class Node{
        public int row;
        public int column;
        public int time;
        public Node( int row, int column, int time){
            this.row= row;
            this.column = column;
            this.time = time;
        }
    }

    public int solve(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        if(rows==0)
            return 0;
        int columns = matrix.get(0).size();

        Queue<Node> queue = new LinkedList<>();

        int freshOranges = 0;

        for(int row = 0; row < rows; row++){
            ArrayList<Integer> list = matrix.get(row);
            for(int column = 0; column < columns; column++){
                if(list.get(column)==1)
                    freshOranges++;
                else if(list.get(column)==2)
                    queue.offer(new Node(row, column, 0));
            }
        }

        int maxTime = 0;
        while(!queue.isEmpty()){
            Node next = queue.poll();
            int[][] neighbours = {            {-1, 0},
                    {1, 0},
                    {0, -1},
                    {0, 1}
            };

            maxTime = Math.max(maxTime, next.time);
            for(int[] neighbour: neighbours){
                int newRow = next.row + neighbour[0];
                int newColumn = next.column + neighbour[1];
                if(newRow >=0 && newRow < rows && newColumn>=0 && newColumn < columns ){
                    if(matrix.get(newRow).get(newColumn)==1)                    {
                        queue.offer(new Node(newRow, newColumn, next.time+1));
                        matrix.get(newRow).set(newColumn, 2);
                        freshOranges--;}
                }
            }
        }
        return freshOranges > 0 ? -1 : maxTime;
    }
}
