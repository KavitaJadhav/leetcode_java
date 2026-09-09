//https://www.scaler.com/academy/mentee-dashboard/class/514025/homework/problems/17892/submissions
 package patterns.bit_manupulation;
//unset k bits from the last
public class UnsetBits {
    public Long solve(Long number, int bits) {
        for(int index = 0; index < bits; index++){
            // number &= ~(1<<index);
            number >>= bits;
            number <<= bits;
        }
        return number;
    }
}
