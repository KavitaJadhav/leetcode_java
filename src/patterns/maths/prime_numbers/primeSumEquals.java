package patterns.maths.prime_numbers;
//https://www.scaler.com/academy/mentee-dashboard/class/514029/assignment/problems/297?navref=cl_tt_nv
public class primeSumEquals {
}
public class Solution {
    public ArrayList<Integer> primesum(int A) {
        boolean[] primes = new boolean[A+1];
        Arrays.fill(primes, true);

        for(int index = 2; index*index <= A;index++){
            if(primes[index]){
                for(long multiple = index*index; multiple<=A; multiple+=index){
                    primes[(int)multiple]=false;
                }
            }
        }

        ArrayList<Integer> primeValues = new ArrayList<>();
        for(int index = 2; index<=A; index++){
            if(primes[index])
                primeValues.add(index);
        }

        int left = 0;
        int right = primeValues.size()-1;
        while (left <= right){
            int leftValue = primeValues.get(left);
            int rightValue = primeValues.get(right);
            if(leftValue+rightValue==A){
                break;
            }else            if(leftValue+rightValue<A){
                left++;
            }else {
                right--;
            }
        }
        return new ArrayList<>(Arrays.asList(primeValues.get(left), primeValues.get(right)));

    }
}
