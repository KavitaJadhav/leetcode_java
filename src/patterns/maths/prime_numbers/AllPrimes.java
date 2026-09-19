//https://www.scaler.com/academy/mentee-dashboard/class/514029/assignment/problems/35398?navref=cl_tt_lst_sl
package patterns.maths.prime_numbers;

public class AllPrimes {

    public ArrayList<Integer> solve(int A) {
        boolean[] primes = new boolean[A+1];
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.fill(primes, true);

        for(int number = 2; number <=A; number++){
            for(long start = number+number; start<=A; start+=number){
                primes[(int)start]=false;
            }
        }

        for(int number = 2; number <=A; number++){
            if(primes[number])
                result.add(number);
        }
        return result;
    }

}
