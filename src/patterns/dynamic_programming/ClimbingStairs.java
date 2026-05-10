//https://leetcode.com/problems/climbing-stairs/
// | Metric | Value |
//| ------ | ----- |
//| Time   | O(n)  |
//| Space  | O(1)  |

//Climbing Stairs:
//Number of ways to reach the top = sum of ways from next step and next-next step (ways[i] = ways[i+1] + ways[i+2]). Initialized last step as 1 and second-last as 2; basically a Fibonacci pattern.

package patterns.dynamic_programming;

class ClimbingStairs {
    public int climbStairs(int num) {

        if (num <= 2) return num;
        int[] result = new int[num];

        result[num - 1] = 1;
        result[num - 2] = 2;

        for (int index = num - 3; index >= 0; index--) {
            result[index] = result[index + 1] + result[index + 2];
        }

        return result[0];
    }

    //todo: explore
    public int climbStairs1(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // f(n-2)
        int prev1 = 2; // f(n-1)

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
