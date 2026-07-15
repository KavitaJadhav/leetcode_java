package patterns.backtrack;

import java.util.ArrayList;

public class MatrixPossiblePaths {

    public ArrayList<String> PrintAllPaths(int rows, int columns) {
        ArrayList<String> results = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        explore(results, path, 0, 0, rows - 1, columns - 1);
        return results;
    }

    private void explore(ArrayList<String> results, StringBuilder path, int rIndex, int cIndex, int tRow, int tColumns) {
        if (rIndex > tRow || cIndex > tColumns)
            return;
        if (rIndex == tRow && cIndex == tColumns) {
            results.add(path.toString());
            return;
        }
        path.append('D');
        explore(results, path, rIndex + 1, cIndex, tRow, tColumns);
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        explore(results, path, rIndex, cIndex + 1, tRow, tColumns);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        MatrixPossiblePaths matrixPossiblePaths = new MatrixPossiblePaths();
        System.out.println(matrixPossiblePaths.PrintAllPaths(3, 1));
    }
}
