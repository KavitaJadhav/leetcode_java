package patterns.backtrack;

import java.util.ArrayList;

public class NumberPermutations {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> input) {
        boolean[] visited = new boolean[input.size()];

        for (int index = 0; index < input.size(); index++) {
            visited[index] = false;
        }
        ArrayList<Integer> combination = new ArrayList<>();
        compute(input, visited, combination);

        return result;
    }

    private void compute(ArrayList<Integer> input, boolean[] visited, ArrayList<Integer> combination) {
        if (combination.size() == input.size()) {
            result.add(new ArrayList<>(combination)) ;
            return;
        }

        for (int index = 0; index < input.size(); index++) {
            if (visited[index] == false) {
                combination.add(input.get(index));
                visited[index] = true;
                compute(input, visited, combination);
                combination.remove(combination.size() - 1);
                visited[index] = false;
            }
        }
    }

    public static void main(String[] args) {
        NumberPermutations numberPermutations = new NumberPermutations();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.println(numberPermutations.permute(input));
    }
}
