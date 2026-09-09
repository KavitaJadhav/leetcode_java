package patterns.stack;

public class DeepestTunnel {

    public int maxDepth(String input) {
        int depth = 0;
        int maxDepth = 0;
        Stack<Character> stack = new Stack();
        for(int index = 0; index<input.length(); index++){
            char ch = input.charAt(index);
            if(ch=='('){
                stack.push('(');
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            }else if(ch==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                    depth--;
                }
            }
        }
        return maxDepth;
    }
}
