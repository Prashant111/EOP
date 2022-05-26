package primitives_types.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DuplicateSortedArrayTest {
    DuplicateSortedArray duplicateSortedArray;

    @Test
    public void test_duplicateSortedArray() {
        int[] input = {2, 3, 5, 5, 7, 11, 11, 11, 13};
        duplicateSortedArray = new DuplicateSortedArray(input);
        int[] actual = duplicateSortedArray.duplicateSortedArray();
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 0, 0, 0}, actual);
    }

    @Test(expected = DuplicateSortedArray.NullInput.class)
    public void test_nullInput() {
        duplicateSortedArray = new DuplicateSortedArray(null);
    }

    @Test(expected = DuplicateSortedArray.NoInput.class)
    public void test_noInput() {
        int[] input = {};
        duplicateSortedArray = new DuplicateSortedArray(input);
    }

    @Test(expected = DuplicateSortedArray.InputContainsNegativeNumber.class)
    public void test_containsNegativeInput() {
        int[] input = {1, -1};
        duplicateSortedArray = new DuplicateSortedArray(input);
    }

    @Test
    public void test_singleZeroInput() {
        int[] input = {0};
        duplicateSortedArray = new DuplicateSortedArray(input);
        int[] actual = duplicateSortedArray.duplicateSortedArray();
        assertArrayEquals(new int[]{0}, actual);
    }

    @Test
    public void test_singleOneInput() {
        int[] input = {1};
        duplicateSortedArray = new DuplicateSortedArray(input);
        int[] actual = duplicateSortedArray.duplicateSortedArray();
        assertArrayEquals(new int[]{1}, actual);
    }

    @Test
    public void test_fiveOnesInput() {
        int[] input = {1, 1, 1, 1, 1};
        duplicateSortedArray = new DuplicateSortedArray(input);
        int[] actual = duplicateSortedArray.duplicateSortedArray();
        assertArrayEquals(new int[]{1, 0, 0, 0, 0}, actual);
    }

    @Test
    public void test_allDistinctInput() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        duplicateSortedArray = new DuplicateSortedArray(input);
        int[] actual = duplicateSortedArray.duplicateSortedArray();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, actual);
    }
}