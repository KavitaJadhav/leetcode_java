package patterns.heap;

public class MinimumLargestElement {

    public int solve(ArrayList<Integer> values, int operations) {
        int maxValue=Integer.MIN_VALUE;

        for(int value: values){
            maxValue= Math.max(value, maxValue);
        }

        int min = maxValue;
        int max = maxValue*(operations+1);
        while(min<max){
            int mid = min + (max-min)/2;
            int currentOperations=0;
            for(int value: values){
                currentOperations += (mid/value)-1;
            }
            if(currentOperations >= operations){
                max = mid;
            }else{
                min = mid+1;
            }

        }
        return min;
    }
}