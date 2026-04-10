//https://leetcode.com/problems/bitwise-and-of-numbers-range/

//| Complexity        | Analysis                                            |
//| ----------------- | --------------------------------------------------- |
//| **Time** O(log n) | Each iteration shifts `m` and `n` right until equal |
//| **Space** O(1)    | Constant extra variables                            |

//If asked:
//Why O(log N)?
//Because each iteration right-shifts the number, effectively dividing it by 2. The number of times we can divide N by 2 is log₂N.
//
//Follow-up (why not O(32)?)
//Since integers are fixed to 32 bits in Java, the loop runs at most 32 times, so practically it's O(1). But theoretically we express it as O(log N).

//Interview Summary (2–3 lines)
//Keep shifting m and n right until they match to find the common prefix. Shift the prefix back to get the AND of the full range.

package patterns.bit_manupulation;

public class bitwiseAndRange {
    public int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;

        while(left < right){
            left >>=1;
            right >>=1;
            shifts++;
        }

        return left<<shifts;
    }
}

//Step-by-Step Example
//m = 5 (101₂), n = 7 (111₂)
//
//Iteration	m	n	shift
//0	101	111	0
//1	10	11	1
//2	1	1	2
//
//Now m = n = 1 → common prefix
//Shift back: 1 << 2 = 100₂ = 4 ✅


//Basic idea
// AND of all numbers from left to right
//O(n) not accepted;

class bitwiseAndRangeSolution {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;

        for(int count = left+1; count<=right; count++){
            result &= count;
        }
        return result;
    }
}
