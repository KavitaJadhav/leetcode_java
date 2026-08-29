package patterns.maths.other;

public class DeviserGame {
    public int solve(int A, int B, int C) {
        if(A<=0)
            return 0;
        return A/ lcm(B, C);

    }

    private int lcm(int num1, int num2){
        return (num1*num2)/gcd(num1, num2);
    }
    private int gcd(int num1, int num2){
        if(num1 < num2)
            return gcd(num2, num1);
//        Assuming 1st no will be greater;
        if(num2==0)
            return num1;
        if(num2==1)
            return 1;
        if(num1%num2==0)
            return num2;

        return gcd(num2, num1%num2);
    }
}

