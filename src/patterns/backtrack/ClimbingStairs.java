package patterns.backtrack;

import java.util.ArrayList;

public class ClimbingStairs {
    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sequence = new ArrayList<>();
        climb(result, sequence, A);
        return result;
    }
    private void climb(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sequence, int pending){
        if(pending==0){
            result.add(new ArrayList<>(sequence));
            return;
        }

        sequence.add(1);
        climb(result, sequence, pending-1);
        sequence.remove(sequence.size()-1);

        if(pending>=2){
            sequence.add(2);
            climb(result, sequence, pending-2);
            sequence.remove(sequence.size()-1);
        }
        // return result;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.WaysToClimb(2));
        System.out.println(climbingStairs.WaysToClimb(3));
    }
}
