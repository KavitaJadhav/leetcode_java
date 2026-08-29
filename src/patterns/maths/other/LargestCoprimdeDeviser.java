//https://www.scaler.com/academy/mentee-dashboard/class/514024/homework/problems/358/?navref=cl_pb_nv_tb
 package patterns.maths.other;

public class LargestCoprimdeDeviser {

    public int cpFact(int num1, int num2) {
        int gcd;
        do{
            gcd = gcd(num1, num2);
            num1=num1/gcd;
        }while(gcd != 1);
        return num1;
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

//Maximum Divisor of A Coprime with B
//
//Goal: Find maximum X such that:
//
//A % X == 0
//gcd(X, B) == 1
//Key Idea
//
//X is a divisor of A, but it cannot contain any prime factor that B contains.
//
//So remove all common factors of A and B from A.
//
//        Approach
//while gcd(A, B) != 1:
//A = A / gcd(A, B)
//
//At the end:
//
//X = A
//        Example
//A = 60
//B = 12
//
//Factorization:
//
//        60 = 2² × 3 × 5
//        12 = 2² × 3
//
//Common factors: 2, 3
//
//Remove them:
//
//        60 → 30 → 15 → 5
//
//Now:
//
//gcd(5, 12) = 1
//
//Therefore:
//
//X = 5
//Why this gives maximum X
//
//We only remove factors from A that make it not coprime with B. Everything remaining can be included in X, making it as large as possible.
//
//Pattern to remember
//
//Maximum divisor of A coprime with B → repeatedly divide A by gcd(A, B).
//
//Complexity: O(log A) per GCD operation; overall very small for standard integer constraints.