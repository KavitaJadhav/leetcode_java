//https://leetcode.com/problems/n-queens/

//| Aspect               | Complexity                                                    |
//| -------------------- | ------------------------------------------------------------- |
//| Time (worst-case)    | O(n!) + O(S × n²)                                             |
//| Space (board + sets) | O(n²)                                                         |
//| Recursion patterns.stack      | O(n)                                                          |
//| Practical note       | Pruning with columns + diagonals reduces actual runtime a lot |

//O(S × n²) - Adding the snapshot
//O(n!) - row column traverse
//Row 1: n options
//Row 2: n-1 options (cannot use same column)
//Row 3: n-2 options

package patterns.backtrack;

public class NQueensOptimized {
//    Todo: optimize for memory.
//    replace set with arrays
}

//N‑Queens Optimizations (Quick)
//
//        Backtracking is key
//
//        Place queens row by row.
//
//        Prune invalid columns/diagonals early.
//
//        Use Bitmasking instead of Sets
//
//        Represent columns and diagonals as integers.
//
//        Fast O(1) checks and lower memory.
//
//        Store only column indices per row
//
//        int[] queens = new int[n]
//
//        Build the board only when saving a solution.
//
//        Reduces O(n²) space → O(n)
//
//        Symmetry pruning
//
//        Only explore half of first row (mirror solutions).
//
//        Roughly halves computations.
//
//        Avoid unnecessary checks
//
//        Always check columns/diagonals before recursive call.
//
//        Optional iterative DFS
//
//        For very large n, can avoid recursion patterns.stack overflow.
//
//        Complexity:
//
//        Time: O(n!) — still factorial, but constants reduced
//
//        Space: O(n) (board storage minimized)