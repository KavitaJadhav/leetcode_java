package patterns.recursion;

public class SumOfDigits {
    public int solve(int num) {
        if(num==0)
            return 0;
        int result = num%10;
        return result + solve(num/10);
    }
}
