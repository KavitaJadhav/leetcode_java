//https://leetcode.com/problems/n-queens/

//| Aspect               | Complexity                                                    |
//| -------------------- | ------------------------------------------------------------- |
//| Time (worst-case)    | O(n!) + O(S × n²)                                             |
//| Space (board + sets) | O(n²)                                                         |
//| Recursion stack      | O(n)                                                          |
//| Practical note       | Pruning with columns + diagonals reduces actual runtime a lot |

//O(S × n²) - Adding the snapshot
//O(n!) - row column traverse
//Row 1: n options
//Row 2: n-1 options (cannot use same column)
//Row 3: n-2 options

package backtrack;

import java.util.*;

public class NQueensOptimized {
//    Todo: optimize for memory.
//    replace set with arrays
}