//https://www.scaler.com/academy/mentee-dashboard/class/523682/homework/problems/5697/submissions
package patterns.binary_search.bsOnAnswer;
// Ath Magical number divided by B or C;
//min - min from b/c
//max = A*min
//compare mid with - mid/b+mid/c+mid/lcm

public class AthMagicNumber {
    public int solve(int A, int B, int C) {
        int mod = 1000000007;

        long b = (long) B;
        long c = (long) C;
        long min = Math.min(b, c);
        long max = (long)A * min;
        long lcm = b / gcd(b, c) * c;

        while (min < max) {
            long mid = min + ((max - min) / 2);
            // long lcm = b / gcd(b, c) * c;
            long values = (mid / b) + (mid / c) - (mid / lcm);
            if (values >= A) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int) (min % mod);    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new AthMagicNumber().solve(4, 2,3));
        System.out.println(new AthMagicNumber().solve(4, 4,3));
    }
}
//  A = 4
//  B = 2
//  C = 3
// 2,3,4,6
// 10, 15, 5
// 10,15,20,30,40

//lcm - 6,3
//        2*3
//        3*1
//
