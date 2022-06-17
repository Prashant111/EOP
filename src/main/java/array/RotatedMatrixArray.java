package array;

import java.util.Arrays;
import java.util.Objects;

public class RotatedMatrixArray {
    private int[][] mat;

    public RotatedMatrixArray(int[][] mat) {
        handleException(mat);
        this.mat = mat;
    }

    private void handleException(int[][] mat) {
        if (Objects.isNull(mat))
            throw new NullInput();
        if (mat.length == 0 || mat[0].length == 0)
            throw new NoInput();
    }

    public int[][] rotateArray() {
        if (mat.length != mat[0].length)
            throw new NoSquareMatrix();
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            result[i] = Arrays.copyOf(mat[i], mat[i].length);

        int max = result.length - 1;
        for (int j = 0; j < result.length / 2; j++) {
            for (int i = 0; i < result.length - 2 * j - 1; i++) {
                int backup = result[j][i + j];
                result[j][i + j] = result[max - (i + j)][j];
                result[max - (i + j)][j] = result[max - j][max - (i + j)];
                result[max - j][max - (i + j)] = result[i + j][max - j];
                result[i + j][max - j] = backup;
            }
        }

        return result;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class NoSquareMatrix extends RuntimeException {
    }

}
