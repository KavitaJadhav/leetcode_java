//https://leetcode.com/problems/climbing-stairs/
// | Metric | Value |
//| ------ | ----- |
//| Time   | O(n)  |
//| Space  | O(1)  |

        package DynamicProgramming;

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
}
