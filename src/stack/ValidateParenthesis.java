//https://leetcode.com/problems/valid-parentheses/
//https://github.com/KavitaJadhav/data_structure_questions/blob/main/ds_patterns/stack/parentheses
//
//Time: O(n) — iterate string once
//Space: O(n) — worst-case all openings on stack
//

package stack;

import java.util.*;

class ValidateParenthesis {
    public boolean isValid(String string) {
        if (string.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // "()[]{}"


        for (int index = 0; index < string.length(); index++) {
            Character c = string.charAt(index);
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek().equals(map.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateParenthesis validateParenthesis = new ValidateParenthesis();
        System.out.println(validateParenthesis.isValid("()"));
        System.out.println(validateParenthesis.isValid("{[()]}"));
        System.out.println(validateParenthesis.isValid("))"));
        System.out.println(validateParenthesis.isValid("(("));
        System.out.println(validateParenthesis.isValid(")("));
        System.out.println(validateParenthesis.isValid("("));
    }
}