package patterns.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

//Note: return if subset. not how many subsets
public class SubSetSum {

    public int subsetSum(ArrayList<Integer> input, int target) {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        int combinationSum=0;
        generate(input, subsets, combination, combinationSum, target, 0);

        return (subsets.size() > 0) ? 1: 0;
    }

    private void generate(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> subsets, ArrayList<Integer> combination,
                          int combinationSum, int target, int index){
        if(index==input.size()){
//            System.out.println(combination.toString());
            if(combinationSum==target)
                subsets.add(new ArrayList<>(combination));
//            System.out.println(subsets.size());
            return;
        }

        // dont add
        generate(input, subsets, combination, combinationSum, target, index+1);

        // add
        int valueAtIndex = input.get(index);
        combination.add(valueAtIndex);
        combinationSum+=valueAtIndex;
        generate(input, subsets, combination, combinationSum, target, index+1);
        combination.remove(combination.size()-1);
        combinationSum-=valueAtIndex;
        return;
    }

    public static void main(String[] args) {
        System.out.println(new SubSetSum().subsetSum(new ArrayList<>(Arrays.asList(1,2,3)), 3));
    }

}
