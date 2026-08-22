//https://www.scaler.com/academy/mentee-dashboard/class/514024/assignment/problems/201?navref=cl_tt_nv
package patterns.maths.other;

public class Power {
    // Do not write code to include libraries, main() function or accept any input from the console.
// Initialization code is already written and hidden from you. Do not write code for it again.
    public int pow(int number, int power, int mod) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        if (mod == 1)
            return 0;

        long result = calculate(number, power, mod);
        if (result < 0)
            result += mod;
        return (int) result;
    }

    public long calculate(int number, int power, int mod) {
        if (power == 0)
            return 1 % mod;

        long half = calculate(number, power / 2, mod);
        long result = (half * half) % mod;

        if (power % 2 == 1)
            result = (result * number) % mod;
        return result;
    }
}


