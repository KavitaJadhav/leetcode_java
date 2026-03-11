//https://leetcode.com/problems/product-of-array-except-self/
package two_pointers;

import java.util.*;

//Time Complexity:
//O(n)+O(n)+O(n)=O(n)

//Space Complexity:
//leftProduct → O(n)
//rightProduct → O(n)
//product → O(n)
//Total: O(3n) → simplified as O(n) extra space

//✅ Summary:
//Complexity	Original Approach
//Time	O(n)
//Space	O(n)

class ProductExcludingSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] product = new int[nums.length];

        Arrays.fill(rightProduct, 1);
        Arrays.fill(leftProduct, 1);

        for (int index = 1; index < nums.length; index++) {
            leftProduct[index] = leftProduct[index - 1] * nums[index - 1];
        }

        for (int index = nums.length - 2; index >= 0; index--) {
            rightProduct[index] = rightProduct[index + 1] * nums[index + 1];
        }


        for (int index = 0; index < nums.length; index++) {
            product[index] = leftProduct[index] * rightProduct[index];
        }

        System.out.println(Arrays.toString(product));
        return product;
    }
}
//
//Code structure
//product array → stores left product first, then multiplied by right product on the fly
//right variable → stores cumulative product from the right
//
//Time Complexity:
//Build left product → O(n)
//Multiply by right product → O(n)
//Total: O(n)
//
//Space Complexity:
//product array → O(n) (output array)
//right → O(1)
//Total: O(1) extra space (ignoring output array)
//
//✅ Summary:
//
//Complexity	Optimized Approach
//Time	O(n)
//Space	O(1) extra

//Optimised for space
//Use one array and one variable
class ProductExcludingSelfOptimised {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];

        Arrays.fill(product, 1);

        for (int index = 1; index < nums.length; index++) {
            product[index] = product[index - 1] * nums[index - 1];
        }

        int right = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            product[index] = product[index] * right;
            right = right * nums[index];
        }

        System.out.println(Arrays.toString(product));
        return product;
    }
}