package array;


import array.DutchFlagPartition;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class DutchFlagPartitionTest {

    private DutchFlagPartition dutchFlagPartition;

    @Test
    public void test_partition() {
        int[] input = {1, 3, 4};
        int index = 2;
        this.dutchFlagPartition = new DutchFlagPartition(input, index);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{1, 3, 4}, actual);
    }

    @Test(expected = DutchFlagPartition.NullInput.class)
    public void test_NullInput() {
        new DutchFlagPartition(null, 1);
    }

    @Test(expected = DutchFlagPartition.NoInput.class)
    public void test_NoInputInput() {
        new DutchFlagPartition(new int[]{}, 0);
    }

    @Test(expected = DutchFlagPartition.NegativeIndex.class)
    public void test_NegativeIndex() {
        int[] input = {1, 3, 4};
        new DutchFlagPartition(input, -1);
    }

    @Test(expected = DutchFlagPartition.IndexOutOfRange.class)
    public void test_OutOfRangeIndex() {
        int[] input = {1, 3, 4};
        new DutchFlagPartition(input, 5);
    }

    @Test(expected = DutchFlagPartition.IndexOutOfRange.class)
    public void test_IndexEqualToSizeOfInput() {
        int[] input = {1, 3, 4};
        new DutchFlagPartition(input, 3);
    }

    @Test()
    public void test_OneNumberPartition() {
        int[] input = {1};
        dutchFlagPartition = new DutchFlagPartition(input, 0);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{1}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_1() {
        int[] input = {1, 2};
        dutchFlagPartition = new DutchFlagPartition(input, 0);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{1, 2}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_2() {
        int[] input = {2, 1};
        dutchFlagPartition = new DutchFlagPartition(input, 0);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{1, 2}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_3() {
        int[] input = {1, 1, 1, 1, 0, 2, 2, 2, 1};
        dutchFlagPartition = new DutchFlagPartition(input, 6);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{1, 1, 1, 1, 0, 1, 2, 2, 2}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_4() {
        int[] input = {0, 1, 2, 0, 2, 1, 1};
        dutchFlagPartition = new DutchFlagPartition(input, 3);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{0, 0, 2, 2, 1, 1, 1}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_5() {
        int[] input = {0, 1, 2, 0, 2, 1, 1};
        dutchFlagPartition = new DutchFlagPartition(input, 2);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{0, 1, 0, 1, 1, 2, 2}, actual);
    }

    @Test()
    public void test_TwoNumberPartition_6() {
        int[] input = {1, 1, 1, 1, 0, 2, 2, 2, 1};
        dutchFlagPartition = new DutchFlagPartition(input, 4);
        int[] actual = dutchFlagPartition.partition();
        assertArrayEquals(new int[]{0, 1, 1, 1, 2, 2, 2, 1, 1}, actual);
    }

}