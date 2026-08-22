package patterns.greedy;
import java.util.*;
public class MiceAndHoles {
        public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {

            Collections.sort(A);
            Collections.sort(B);

            int answer = 0;

            for (int i = 0; i < A.size(); i++) {
                answer = Math.max(answer,
                        Math.abs(A.get(i) - B.get(i)));
            }

            return answer;
        }
}
