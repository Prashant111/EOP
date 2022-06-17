package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpiralMatrixArray {
    private int[][] mat;

    public SpiralMatrixArray(int[][] mat) {
        handleException(mat);
        this.mat = mat;
    }

    private void handleException(int[][] mat) {
        if (Objects.isNull(mat))
            throw new NullInput();
        if (mat.length == 0 || mat[0].length == 0)
            throw new NoInput();
    }

    public List<Integer> spiralIteration() {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = mat.length - 1;
        int endCol = mat[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(mat[startRow][i]);
            }
            startRow++;
            if(startRow > endRow)
                break;
            for (int i = startRow; i <= endRow; i++) {
                result.add(mat[i][endCol]);
            }
            endCol--;
            if(startCol > endCol)
                break;
            for (int i = endCol; i >= startCol; i--) {
                result.add(mat[endRow][i]);
            }
            endRow--;
            if(startRow > endRow)
                break;
            for (int i = endRow; i >= startRow; i--) {
                result.add(mat[i][startCol]);
            }
            startCol++;
            if(startCol > endCol)
                break;
        }
        return result;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

}
