package patterns.dynamic_programming.matrix;

//Given a 2D binary matrix grid filled with 0s and 1s, find the largest rectangle containing only 1s and return its area.
import java.util.*;
//1. Time Complexity: $O(R \times C)$
//2. Space Complexity: $O(C)$


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
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0)));
        grid.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0)));

        System.out.println(new LargestRectangle().maximalRectangle(grid));

        ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
        grid2.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0)));
        grid2.add(new ArrayList<>(Arrays.asList(1, 1, 1,0, 1)));
        grid2.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1)));
        grid2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0)));

        System.out.println(new LargestRectangle().maximalRectangle(grid2));
    }
}
