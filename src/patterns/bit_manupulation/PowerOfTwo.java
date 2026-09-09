//https://leetcode.com/problems/power-of-two/

package patterns.bit_manupulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        return (n & (n-1))==0;
    }
}
//Since the power of 2 has the only most significient bit set like 10,100,1000
// and previous num - most significent bit becomes 0 and other bits becomes 1 resulting and as 0
//10 - 1010 & 1001 - 1000 - No
//4 - 100&011 = 0 -Yes
//16 = 10000 & 01111-0 -YES