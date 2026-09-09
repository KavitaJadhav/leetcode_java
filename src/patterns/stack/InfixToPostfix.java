package patterns.stack;

import java.util.*;

public class InfixToPostfix {

    public String solve(String input) {
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        // Set<Character> operators = new HashSet<>(Arrays.asList('^', '/', '*', '+', '-'));
        Map<Character, Integer> operators = new HashMap<>();
        operators.put('^', 3);
        operators.put('/', 2);
        operators.put('*', 2);
        operators.put('+', 1);
        operators.put('-', 1);

        for(int index = 0; index < input.length(); index++){
            char character = input.charAt(index);

            if(operators.containsKey(character)){
                while(!stack.isEmpty() && stack.peek() != '(' && operators.get(stack.peek())>=operators.get(character))
                    result.append(stack.pop());
                stack.push(character);
            }
            else if(character==')'){
                while(!stack.isEmpty() && stack.peek()!='(')
                    result.append(stack.pop());
                stack.pop();
            }
            else if(character=='(')
                stack.push(character);
            else
                result.append(character);
        }
        while(!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();
    }
}
