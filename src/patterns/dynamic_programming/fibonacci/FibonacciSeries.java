package patterns.dynamic_programming.fibonacci;

import java.lang.*;
import java.util.*;

public class FibonacciSeries {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int index = 2; index <= num; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        int result = 0;
        System.out.println(dp[num]);
    }
}