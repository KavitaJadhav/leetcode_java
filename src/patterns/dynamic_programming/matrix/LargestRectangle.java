package patterns.dynamic_programming.matrix;

import java.util.*;

public class LargestRectangle {

    class Pair{
        public int index;
        public int value;
        public Pair(int index, int value){
            this.index= index;
            this.value = value;
        }

    }
    public int maximalRectangle(ArrayList<ArrayList<Integer>> grid) {
        if(grid.size()==0)
            return 0;

        int rows = grid.size();
        int columns = grid.get(0).size();
        int[] reduced = new int[columns];

        int result = 0;
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                if(grid.get(row).get(column)==0)
                    reduced[column] = 0;
                else
                    reduced[column] = reduced[column]+1;
            }
            result = Math.max(result, largestHistogrm(reduced));
        }
        return result;
    }
    private int largestHistogrm(int[] array){
        int result=0;
        Stack<Pair> stack = new Stack<>();

        for(int index = 0; index < array.length; index++){
            int updateIndex = index;
            while(!stack.isEmpty()&& stack.peek().value > array[index]){
                Pair prev = stack.pop();
                int length = index - prev.index;
                int height = prev.value;
                result = Math.max(result, length*height);
                updateIndex =   prev.index;
            }
            stack.push(new Pair(updateIndex, array[index]));
        }
        while(!stack.isEmpty()){
            Pair prev = stack.pop();
            int length = array.length - prev.index;
            int height = prev.value;
            result = Math.max(result, length*height);
        }
        // System.out.print(" "+Arrays.toString(array));
        return result;
    }
}
