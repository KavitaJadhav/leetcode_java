//https://leetcode.com/problems/power-of-two/

package bit_manupulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        return (n & (n-1))==0;
    }
}