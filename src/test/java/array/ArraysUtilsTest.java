package array;

import array.ArraysUtils;
import org.junit.Assert;
import org.junit.Test;

public class ArraysUtilsTest {

    @Test(expected = ArraysUtils.NullInput.class)
    public void test_swapNullInputArray() {
        ArraysUtils.swap(null, 1, 2);
    }

    @Test(expected = ArraysUtils.NoInput.class)
    public void test_swapEmptyArray() {
        ArraysUtils.swap(new int[]{}, 0, 0);
    }

    @Test(expected = ArraysUtils.SwapIndexRangeException.class)
    public void test_swapIndexEqualSizeOfArray() {
        ArraysUtils.swap(new int[]{1, 2, 4}, 0, 3);
    }

    @Test(expected = ArraysUtils.SwapIndexRangeException.class)
    public void test_swapIndexNegative() {
        ArraysUtils.swap(new int[]{1, 2, 4}, 2, -1);
    }

    @Test
    public void test_swapFirstIndexLesserThanSecond() {
        int[] input = {1, 2, 4};
        ArraysUtils.swap(input, 1, 2);
        Assert.assertArrayEquals(new int[]{1, 4, 2}, input);
    }

    @Test
    public void test_swapSecondIndexLesserThanFirst() {
        int[] input = {1, 2, 4};
        ArraysUtils.swap(input, 2, 0);
        Assert.assertArrayEquals(new int[]{4, 2, 1}, input);
    }

    @Test
    public void test_swapFirstIndexEqualsSecond() {
        int[] input = {1, 2, 4};
        ArraysUtils.swap(input, 2, 2);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, input);
    }

    @Test
    public void test_swapSingleNumberArray() {
        int[] input = {4};
        ArraysUtils.swap(input, 0, 0);
        Assert.assertArrayEquals(new int[]{4}, input);
    }
}