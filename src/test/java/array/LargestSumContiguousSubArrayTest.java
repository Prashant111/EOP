package array;

import array.LargestSumContiguousSubArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestSumContiguousSubArrayTest {

    private void assertLargestContinuousSubArraySum(int[] input, int expected) {
        LargestSumContiguousSubArray largestSumContiguousSubArray = new LargestSumContiguousSubArray(input);
        int actual = largestSumContiguousSubArray.calculate();
        assertEquals(expected, actual);
    }

    private int[] array(Integer... integers) {
        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++)
            result[i] = integers[i];
        return result;
    }

    private int is(int num) {
        return num;
    }

    @Test(expected = LargestSumContiguousSubArray.NullInput.class)
    public void whenNullInput_thenThrowException() {
        new LargestSumContiguousSubArray(null);
    }

    @Test
    public void whenEmptyArrayInput_thenReturnZero() {
        assertLargestContinuousSubArraySum(array(), is(0));
    }

    @Test
    public void whenSingleNegativeNumberArrayInput_thenReturnZero() {
        assertLargestContinuousSubArraySum(array(-1), is(0));
    }

    @Test
    public void whenMultipleNegativeNumberArrayInput_thenReturnZero() {
        assertLargestContinuousSubArraySum(array(-1, -2, -4), is(0));
    }

    @Test
    public void whenMultipleMixNumbersArrayInput_thenReturnProperResult() {
        assertLargestContinuousSubArraySum(array(-2, -3, 4, -1, -2, 1, 5, -3), is(7));
    }
}