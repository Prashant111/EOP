package array;

import array.RotatedMatrixArray;
import org.junit.Assert;
import org.junit.Test;

public class RotatedMatrixArrayTest {
    private RotatedMatrixArray rotatedMatrixArray;

    @Test(expected = RotatedMatrixArray.NullInput.class)
    public void test_NullInput() {
        new RotatedMatrixArray(null);
    }

    @Test(expected = RotatedMatrixArray.NoInput.class)
    public void test_zeroRows() {
        int[][] mat = new int[0][2];
        new RotatedMatrixArray(mat);
    }

    @Test(expected = RotatedMatrixArray.NoInput.class)
    public void test_zeroCols() {
        int[][] mat = new int[2][0];
        new RotatedMatrixArray(mat);
    }

    @Test(expected = RotatedMatrixArray.NoInput.class)
    public void test_emptyData() {
        new RotatedMatrixArray(new int[][]{{}, {}});
    }


    @Test(expected = RotatedMatrixArray.NoSquareMatrix.class)
    public void test_noSquareMatrix() {
        int[][] mat = {{1}, {2}, {3}, {4},};
        rotatedMatrixArray = new RotatedMatrixArray(mat);
        rotatedMatrixArray.rotateArray();
    }

    @Test
    public void test_spiralIteration2() {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},};
        rotatedMatrixArray = new RotatedMatrixArray(mat);
        int[][] actual = rotatedMatrixArray.rotateArray();
        Assert.assertArrayEquals(new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}, actual);
    }

    @Test
    public void test_spiralIteration4() {
        int[][] mat = {{1, 2}, {3, 4},};
        rotatedMatrixArray = new RotatedMatrixArray(mat);
        int[][] actual = rotatedMatrixArray.rotateArray();
        Assert.assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, actual);
    }

    @Test
    public void test_spiralIteration5() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},};
        rotatedMatrixArray = new RotatedMatrixArray(mat);
        int[][] actual = rotatedMatrixArray.rotateArray();
        Assert.assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3},}, actual);
    }

}