package patterns.stack;
//Given a string consisting only of '(' and ')', return the minimum number of insertions needed to make the string valid such that:
//
//Each '(' must be matched with exactly two consecutive ')'
//The pattern must be: "())"

//)
//))
public class BalanceBrackets {

    public int minInsertions(String s) {
        int open = 0;        // number of unmatched '('
        int insertions = 0;  // number of insertions needed

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else { // ')'
                // Check if this is a pair '))'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // consume both ')'
                } else {
                    // single ')', need one more ')'
                    insertions++;
                }

                if (open > 0) {
                    open--; // match with one '('
                } else {
                    // no '(' available → insert one '('
                    insertions++;
                }
            }
        }

        // remaining '(' each needs 2 ')'
        return insertions + (open * 2);
    }
}