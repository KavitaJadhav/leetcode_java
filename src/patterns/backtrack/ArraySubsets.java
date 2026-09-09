package patterns.backtrack;

import java.util.ArrayList;

public class ArraySubsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> values) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        generate(result,combination,values, 0);
        return result ;
    }
    private void generate(ArrayList<ArrayList<Integer>> result,   ArrayList<Integer> combination, ArrayList<Integer> values, int index){
        if(index==values.size()){
            result.add(new ArrayList<>(combination));
            return;
        }

//don't use the element at index
        generate(result, combination, values, index + 1);

//use the element at index
        combination.add(values.get(index));

        generate(result, combination, values, index+1);
        combination.remove(combination.size()-1);
    }
}

