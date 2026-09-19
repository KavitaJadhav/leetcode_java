//https://www.scaler.com/academy/mentee-dashboard/class/514056/homework/problems/1065/submissions
 package patterns.dynamic_programming.linear_dp;
//In Danceland, one person can party either alone or can pair up with another person.
//Can you find in how many ways they can party if there are A people in Danceland?
//Note: Return your answer modulo 10003, as the answer can be large.
//A = 5

public class PairingFriends {
    public int solve(int count) {
        if(count<=1)
            return 1;
        int mod = 10003;
        int[] dp = new int[count+1];
        dp[0]=1;
        dp[1]=1;

        for(int index= 2; index<=count; index++){
            dp[index] = dp[index-1] + (dp[index-2] * (index-1));
            dp[index]%=mod;
        }
        return dp[count];
    }

    public static void main(String[] args) {
        System.out.println(new PairingFriends().solve(1));
        System.out.println(new PairingFriends().solve(2));
        System.out.println(new PairingFriends().solve(3));
        System.out.println(new PairingFriends().solve(4));
        System.out.println(new PairingFriends().solve(5));
    }
}
//A=4
//0,1,2,3,4
//1,1,2,4,10

// A=3
// 1,2,3
// 12,3
// 13,2
// 1,23

// A = 1
// 1

// A=2
// 1,2
// 12

// A=4
// 1,2,3,4
// 12,3,4
// 13, 2,4
// 1,2,24
// 1,23,4
// 1,2,34
// 14, 2, 3
// 12,34
// 13,24
// 14,23

//FRIENDS PAIRING / DANCELAND
//
//Problem:
//A people can either:
//        1. Party alone
//2. Pair up with exactly one other person
//
//Find the number of ways.
//
//        Pattern:
//        1D DP — Counting Ways
//
//State:
//dp[i] = number of ways i people can party
//
//Think about person i:
//
//CASE 1: Person i goes alone
//--------------------------------
//Remaining people = i - 1
//
//Ways = dp[i - 1]
//
//
//CASE 2: Person i pairs with someone
//------------------------------------
//Person i can choose any of the other (i - 1) people.
//
//For each choice:
//Remaining people = i - 2
//
//Ways = (i - 1) * dp[i - 2]
//
//
//RECURRENCE:
//dp[i] = dp[i - 1] + (i - 1) * dp[i - 2]
//
//Since answer can be large:
//dp[i] %= 10003
//
//
//BASE CASES:
//dp[0] = 1
//dp[1] = 1
//
//
//EXAMPLE:
//A = 3
//
//dp[0] = 1
//dp[1] = 1
//
//dp[2] = dp[1] + 1 * dp[0]
//        = 1 + 1
//        = 2
//
//dp[3] = dp[2] + 2 * dp[1]
//        = 2 + 2
//        = 4
//
//Ways for 3 people:
//ABC       -> all alone
//AB + C
//AC + B
//BC + A
//
//
//WHY dp[0] = 1?
//        ----------------
//There is exactly one way to arrange zero people:
//        do nothing.
//
//It also makes the recurrence work for i = 2.
//
//
//COMPLEXITY:
//Time  = O(A)
//Space = O(A)
//
//Can optimize space:
//Only dp[i-1] and dp[i-2] are needed.
//
//Time  = O(A)
//Space = O(1)
//
//
//KEY INTUITION:
//        ---------------
//Take one person.
//
//They either:
//        - stay alone  -> dp[i-1]
//        - pair with one of (i-1) people -> (i-1) * dp[i-2]
//
//Therefore:
//
//dp[i] = dp[i-1] + (i-1) * dp[i-2]
