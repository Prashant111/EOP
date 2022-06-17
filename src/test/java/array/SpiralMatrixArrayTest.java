package array;

import array.SpiralMatrixArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SpiralMatrixArrayTest {
    private SpiralMatrixArray spiralMatrixArray;

    @Test(expected = SpiralMatrixArray.NullInput.class)
    public void test_NullInput() {
        new SpiralMatrixArray(null);
    }

    @Test(expected = SpiralMatrixArray.NoInput.class)
    public void test_zeroRows() {
        int[][] mat = new int[0][2];
        new SpiralMatrixArray(mat);
    }

    @Test(expected = SpiralMatrixArray.NoInput.class)
    public void test_zeroCols() {
        int[][] mat = new int[2][0];
        new SpiralMatrixArray(mat);
    }

    @Test(expected = SpiralMatrixArray.NoInput.class)
    public void test_emptyData() {
        new SpiralMatrixArray(new int[][]{{}, {}});
    }

    @Test
    public void test_spiralIteration() {
        int[][] mat = {
                {1, 2},
                {3, 4},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 4, 3), expected);
    }

    @Test
    public void test_spiralIteration2() {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), expected);
    }

    @Test
    public void test_spiralIteration3() {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {16, 17, 18, 19},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 3, 4, 8, 12, 19, 18, 17, 16, 9, 5, 6, 7, 11, 10), expected);
    }

    @Test
    public void test_spiralIteration4() {
        int[][] mat = {
                {1, 2, 3, 4},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 3, 4), expected);
    }

    @Test
    public void test_spiralIteration5() {
        int[][] mat = {
                {1},
                {2},
                {3},
                {4},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 3, 4), expected);
    }

    @Test
    public void test_spiralIteration6() {
        int[][] mat = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 4, 6, 5, 3), expected);
    }

    @Test
    public void test_spiralIteration7() {
        int[][] mat = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 4, 6, 5, 3), expected);
    }

    @Test
    public void test_spiralIteration8() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
        };
        spiralMatrixArray = new SpiralMatrixArray(mat);
        List<Integer> expected = spiralMatrixArray.spiralIteration();
        Assert.assertEquals(List.of(1, 2, 3, 6, 5, 4), expected);
    }
}