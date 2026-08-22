//https://www.scaler.com/academy/mentee-dashboard/class/514024/assignment/problems/4110/?navref=cl_pb_nv_tb
package patterns.maths.other;

public class ArrayPairSum {

    public int solve(ArrayList<Integer> values, int sum) {
        long[] mods = new long[sum];

        long mod = 1000000007;

        for(Integer value : values){
            // int index = value%sum;
            mods[value%sum] +=1;
        }

        long result = 0;
        result+=((mods[0]*(mods[0]-1)/2));
        result%=mod;

        for(int num=1; num <= sum/2; num++){
            if(num==sum-num){
                result+=((mods[num]*(mods[num]-1)/2));
                result%=mod;
            }else{
                result+=(mods[num]*mods[sum-num]);
                result%=mod;
            }
        }
        return (int)result;
    }
}
