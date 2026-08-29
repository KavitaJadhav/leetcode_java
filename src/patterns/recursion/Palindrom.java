package patterns.recursion;

public class Palindrom {

    public int solve(String input) {
        return palindrom(input, 0, input.length()-1) ? 1 : 0;
    }

    private boolean palindrom(String input, int startIndex, int endindex){
        if(startIndex>=endindex)
            return true;
        if(input.charAt(startIndex)!= input.charAt(endindex))
            return false;
        return palindrom(input, startIndex+1, endindex-1);
    }
}
