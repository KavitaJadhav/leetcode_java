//https://www.scaler.com/academy/mentee-dashboard/class/523690/homework/problems/1064/submissions
//Pattern
//        This is a Stack → Undo / History pattern.
//        Think of the stack as:
//        "Store every action so that the most recent action can be undone."

package patterns.stack;

import java.util.*;

public class FootBallPasses {
    public int solve(int passesCount, int initialPlayer, ArrayList<Integer> passes) {
        if(passesCount==0)
            return initialPlayer;
        Stack<Integer> stack = new Stack<>();

        for(int index = 0; index < passesCount; index++){
            int pass = passes.get(index);

            if(pass==0){
                stack.pop();
            }else{
                stack.push(pass);
            }
        }
        if(stack.isEmpty())
            return initialPlayer;
        else
            return stack.peek();
    }
}
