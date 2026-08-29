//https://www.scaler.com/academy/mentee-dashboard/class/514020/assignment/problems/10755/submissions
package patterns.recursion;

public class Fibonacci {
    public int findAthFibonacci(int num) {
        if (num == 0)
            return 0;

        if (num == 1)
            return 1;

        return findAthFibonacci(num - 2) + findAthFibonacci(num - 1);
    }
}
