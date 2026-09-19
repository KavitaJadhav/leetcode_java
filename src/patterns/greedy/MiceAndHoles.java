package patterns.greedy;

import java.util.*;

public class MiceAndHoles {
    public int mice(ArrayList<Integer> mices, ArrayList<Integer> holes) {

        Collections.sort(mices);
        Collections.sort(holes);

        int answer = 0;

        for (int index = 0; index < mices.size(); index++) {
            answer = Math.max(answer, Math.abs(mices.get(index) - holes.get(index)));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new MiceAndHoles().mice(new ArrayList<>(Arrays.asList(4, -4, 2)), new ArrayList<>(Arrays.asList(4, 0, 5))));
    }
}
