package mock_practice;

import java.util.Arrays;

public class DynamicPricing {

    private int[] calculate(int baseFair, int[] drivers, int[] requests) {
        int[] result = new int[drivers.length];

        for (int index = 0; index < drivers.length; index++) {
            if (drivers[index] == 0)
                result[index] = 0;
            else if (drivers[index] >= requests[index])
                result[index] = baseFair * requests[index];
            else
                result[index] = (baseFair * requests[index]) / drivers[index];

        }
        return result;
    }

    public static void main(String[] args) {
        DynamicPricing dynamicPricing = new DynamicPricing();
        System.out.println(Arrays.toString(dynamicPricing.calculate(10, new int[]{2}, new int[]{0}))); // edge case
        System.out.println(Arrays.toString(dynamicPricing.calculate(10, new int[]{3}, new int[]{3})));
        System.out.println(Arrays.toString(dynamicPricing.calculate(10, new int[]{2}, new int[]{100})));
        System.out.println(Arrays.toString(dynamicPricing.calculate(10, new int[]{5, 6, 4}, new int[]{2, 3, 1})));
        System.out.println(Arrays.toString(dynamicPricing.calculate(10, new int[]{2, 3, 0, 4}, new int[]{2, 6, 3, 8})));

    }
}
