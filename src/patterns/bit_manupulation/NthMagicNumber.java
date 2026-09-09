//https://www.scaler.com/academy/mentee-dashboard/class/514025/homework/problems/4105/submissions
package patterns.bit_manupulation;
//Given an integer A, find and return the Ath magic number.
//A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
//First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

public class NthMagicNumber {
    public int solve(int counter) {
            int next = 0;
            for(int index = 0; index < 32 ; index++){
                int bit = (counter >> index) & 1;
                if(bit==1){
                    // System.out.print(bit + " ");

                    next+= Math.pow(5, index+1);
                }
            }
            return next;
    }

    public static void main(String[] args) {
        NthMagicNumber nthMagicNumber = new NthMagicNumber();
        System.out.println(nthMagicNumber.solve(5));
        System.out.println(nthMagicNumber.solve(10));
//        130
//        650
    }
}

//|  A | Binary | Magic number |
//| -: | :----: | -----------: |
//|  1 |  `001` |            5 |
//|  2 |  `010` |           25 |
//|  3 |  `011` |           30 |
//|  4 |  `100` |          125 |
//|  5 |  `101` |          130 |
//|  6 |  `110` |          150 |
//|  7 |  `111` |          155 |
//A = 3 = 011
//5² + 5¹ = 25 + 5 = 30
//Binary digits of A → select corresponding powers of 5.