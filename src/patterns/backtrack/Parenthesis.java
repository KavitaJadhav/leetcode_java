package patterns.backtrack;

import java.util.ArrayList;

public class Parenthesis {
    private ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int A) {
        int openParenthesis = A;
        int closingParenthesis = A;
        StringBuilder sb = new StringBuilder();
        backtrack(A, openParenthesis, closingParenthesis, sb);
        return result;
    }

    public void backtrack(int A, int openParenthesis, int closingParenthesis, StringBuilder sb) {
        if (openParenthesis == 0 && closingParenthesis == 0) {
            result.add(sb.toString());
            return;
        }

        System.out.println(openParenthesis+ " "+closingParenthesis+" "+ sb.toString());

        if(closingParenthesis<openParenthesis || openParenthesis==0)
                return;
//
//        if (closingParenthesis >= openParenthesis) {
            sb.append('(');
            openParenthesis--;
            backtrack(A, openParenthesis, closingParenthesis, sb);
            sb.delete(sb.length() - 1, 1);
            openParenthesis++;

            sb.append(')');
            closingParenthesis--;
            backtrack(A, openParenthesis, closingParenthesis, sb);
            sb.delete(sb.length() - 1, 1);
            closingParenthesis++;
//        }
    }

    public static void main(String[] args) {

        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.generateParenthesis(3));
    }
}
