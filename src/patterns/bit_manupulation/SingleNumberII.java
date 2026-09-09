//https://leetcode.com/problems/single-number-ii

//Approach (2–3 lines)
//Use two bitmask variables one and two to track bits appearing 1 time and 2 times modulo 3.
//For each number, update:
//one = (one ^ num) & ~two;
//two = (two ^ num) & ~one;
//After processing all numbers, one contains the unique number.

//| Complexity     | Analysis                                                             |
//| -------------- | -------------------------------------------------------------------- |
//| **Time** O(n)  | Iterate once over the array of `n` elements                          |
//| **Space** O(1) | Only two integer variables `one` and `two` are used (constant space) |


//Other Solutions: Todo: Explore it and implement
//https://www.youtube.com/watch?v=cOFAmaMBVps

//Simple Mental Model 🧩
//Think of it as a base-3 counter for every bit implemented with two registers.
//one → bits seen once
//two → bits seen twice
//third occurrence → clear both

//one number twice
//other number thrice
package patterns.bit_manupulation;

import java.util.List;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;

        for (int num : nums) {
            one = (one ^ num) & (~two);
            two = (two ^ num) & (~one);
        }

        return one;
    }
    public int singleNumber(final List<Integer> numbers) {
        int result = 0;
        for(int index= 31 ; index>=0; index--){

            int[] count = new int[2];
            for(Integer number: numbers){
                int bit = number>>index & 1;
                count[bit]++;
            }
            if(count[0]%3==1)
                result |= (0 << index);
            else
                result |= (1 << index);
        }

        return result;
    }
}