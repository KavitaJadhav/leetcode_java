//https://www.scaler.com/academy/mentee-dashboard/class/514022/homework/problems/6604/submissions
package patterns.bit_manupulation;

import java.util.ArrayList;

public class SubArrayOrSum {
    public int solve(ArrayList<Integer> values) {
        int mod = 1000000007;
        int result = 0;
        int inputSize = values.size();
        // int totalSubArrays = (inputSize* (inputSize+1))/2;
        long totalSubArrays = (long) inputSize * (inputSize + 1) / 2;
        for(int index = 0; index < 32; index++){
            long contributingSubarrays = totalSubArrays;
            int consucativeZeroBits = 0;
            int oneBits = 0;
            for(Integer value : values ){
                int bit = value >> index & 1;
                if(bit==0){
                    consucativeZeroBits++;
                }else{
                    oneBits++;
                    contributingSubarrays-= (consucativeZeroBits*(consucativeZeroBits+1)/2);
                    consucativeZeroBits=0;
                }
            }
            long consucativeSubarrays = consucativeZeroBits*(consucativeZeroBits+1)/2;
            contributingSubarrays-= consucativeSubarrays;

            if(oneBits>0){
                long indexSum = (contributingSubarrays * (1L << index)) % mod;
                result+=indexSum;
                result%=mod;

            }

            // System.out.print(result + " ");
        }

        return result;
    }
}
