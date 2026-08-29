package patterns.recursion;
import java.util.*;
public class TowerOfHanoi {
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int disks) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        toh(result, disks, 1, 3, 2);
        return result;
    }
    public void toh(ArrayList<ArrayList<Integer>> result, int disks, int start, int end, int auxiliary){

        if (disks == 0)
            return;

        toh(result, disks-1, start,auxiliary, end);
        ArrayList<Integer> move = new ArrayList<>();
        move.add(disks);
        move.add(start);
        move.add(end);
        result.add(move);

        toh(result, disks-1, auxiliary, end,start);
    }
}
