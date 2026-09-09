//https://www.scaler.com/academy/mentee-dashboard/class/523690/homework/problems/274/submissions
 package patterns.stack;

import java.util.*;

public class redundantBraces {

    public int braces(String input) {
        Stack<Character> stack = new Stack<>();

        for(int index = 0; index< input.length(); index++){
            char character = input.charAt(index);

            if(character==')'){
                if(!stack.isEmpty()  && stack.peek()=='(')
                    return 1;
                while(!stack.isEmpty() && stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }

            if(character== '(' || character== '+' || character== '-' || character== '*' || character== '/'  )
                stack.push(character);

            // System.out.print(stack.peek() +" ");
        }
        return 0;
    }
}
