//https://leetcode.com/problems/k-th-symbol-in-grammar/
package patterns.backtrack;

public class BinaryIndexValue {
    public int solve(int row, Long index) {
        if (row == 1) {
            return 0;
        } else {
            long parentIndex = index / 2;
            int parentRow = row - 1;

            int parentValue = solve(parentRow, parentIndex);
            int indexValue;
            if (parentValue == 0) {
                indexValue = (index % 2 == 0) ? 0 : 1;
            } else {
                indexValue = (index % 2 == 0) ? 1 : 0;
            }
            return indexValue;
        }

    }
}

public class BinaryIndexValueSimplified {
    public int solve(int row, Long index) {
        if (row == 1) {
            return 0;
        } else {
            long parentIndex = index / 2;
            int parentRow = row - 1;

            int parentValue = solve(parentRow, parentIndex);
            return (index % 2 == 0) ? parentValue : 1 - parentValue;
        }
    }
}
