package primitives_types.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSubsequenceTest {

    @Test(expected = LongestConsecutiveSubsequence.NullInput.class)
    public void whenNullInput_thenThrowException() {
        new LongestConsecutiveSubsequence(null);
    }

    private void assertLongestConsecutiveSubsequenceBySorting(int[] input, int expected) {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence(input);
        int actual = longestConsecutiveSubsequence.longestConsecutiveSubSequenceBySorting();
        assertEquals(expected, actual);
    }

    private void assertLongestConsecutiveSubsequenceByHash(int[] input, int expected) {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence(input);
        int actual = longestConsecutiveSubsequence.longestConsecutiveSubSequenceByHash();
        assertEquals(expected, actual);
    }

    private void longestConsecutiveSubSequenceByPriorityQueue(int[] input, int expected) {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence(input);
        int actual = longestConsecutiveSubsequence.longestConsecutiveSubSequenceByPriorityQueue();
        assertEquals(expected, actual);
    }

    @Test
    public void whenEmptyInputArray_thenReturnZero() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{}, 0);
    }

    @Test
    public void whenSingleInputArray_thenReturnOne() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{10}, 1);
    }

    @Test
    public void whenTwoConsecutiveNumbersInputArray_thenReturnTwo() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{10, 11}, 2);
    }

    @Test
    public void whenTwoNonConsecutiveNumbersInputArray_thenReturnOne() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{10, 12}, 1);
    }

    @Test
    public void whenThreeConsecutiveNumbersInputArray_thenReturnOne() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{10, 11, 12}, 3);
    }

    @Test
    public void whenThreeNonConsecutiveNumbersInputArray_thenReturnOne() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{10, 12, 11}, 3);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{1, 9, 3, 10, 4, 20, 2}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult2() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{4, 10, 11, 5, 6, 15, 7}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult3() {
        assertLongestConsecutiveSubsequenceBySorting(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}, 5);
    }

    @Test
    public void whenEmptyInputArray_thenReturnZero_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{}, 0);
    }

    @Test
    public void whenSingleInputArray_thenReturnOne_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{10}, 1);
    }

    @Test
    public void whenTwoConsecutiveNumbersInputArray_thenReturnTwo_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{10, 11}, 2);
    }

    @Test
    public void whenTwoNonConsecutiveNumbersInputArray_thenReturnOne_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{10, 12}, 1);
    }

    @Test
    public void whenThreeConsecutiveNumbersInputArray_thenReturnOne_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{10, 11, 12}, 3);
    }

    @Test
    public void whenThreeNonConsecutiveNumbersInputArray_thenReturnOne_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{10, 12, 11}, 3);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{1, 9, 3, 10, 4, 20, 2}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult2_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{4, 10, 11, 5, 6, 15, 7}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult3_fromHashApproach() {
        assertLongestConsecutiveSubsequenceByHash(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}, 5);
    }


    @Test
    public void whenEmptyInputArray_thenReturnZero_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{}, 0);
    }

    @Test
    public void whenSingleInputArray_thenReturnOne_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{10}, 1);
    }

    @Test
    public void whenTwoConsecutiveNumbersInputArray_thenReturnTwo_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{10, 11}, 2);
    }

    @Test
    public void whenTwoNonConsecutiveNumbersInputArray_thenReturnOne_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{10, 12}, 1);
    }

    @Test
    public void whenThreeConsecutiveNumbersInputArray_thenReturnOne_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{10, 11, 12}, 3);
    }

    @Test
    public void whenThreeNonConsecutiveNumbersInputArray_thenReturnOne_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{10, 12, 11}, 3);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{1, 9, 3, 10, 4, 20, 2}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult2_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{4, 10, 11, 5, 6, 15, 7}, 4);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult3_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}, 5);
    }

    @Test
    public void whenMultipleConsecutiveNumbersInputArray_thenReturnResult4_fromPriorityQueueApproach() {
        longestConsecutiveSubSequenceByPriorityQueue(new int[]{36, 41, 56, 56, 56, 56, 35, 44, 33, 34, 92, 43, 32, 42}, 5);
    }
}