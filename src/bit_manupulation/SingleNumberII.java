//https://leetcode.com/problems/single-number-ii/submissions/1948997701/

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


//Other Solutions:
//https://www.youtube.com/watch?v=cOFAmaMBVps

package bit_manupulation;

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
}