package patterns.dynamic_programming.maximum_subarray;

import java.util.List;

public class SubArrayMaxProduct {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> input) {
        if(input.size()==0)
            return 0;

        int result = input.get(0);
        int minProduct = input.get(0);
        int maxProduct = input.get(0);

        for(int index = 1; index< input.size(); index++){
            int value = input.get(index);
            int previousMax = maxProduct;

            maxProduct = Math.max(value, Math.max(maxProduct*value, minProduct*value));
            minProduct = Math.min(value, Math.min( minProduct*value, previousMax*value));

            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
