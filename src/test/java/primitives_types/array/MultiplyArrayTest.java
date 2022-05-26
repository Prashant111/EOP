package primitives_types.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyArrayTest {
    private MultiplyArray multiplyArray;

    @Test(expected = MultiplyArray.NullInput.class)
    public void test_NullInput() {
        new MultiplyArray(null, List.of(1));
    }

    @Test(expected = MultiplyArray.NoInput.class)
    public void test_NoInput() {
        new MultiplyArray(List.of(), List.of(1));
    }

    @Test(expected = MultiplyArray.InputHavingNull.class)
    public void test_InputHavingNull() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, null, 3));
        List<Integer> list2 = List.of(1, 2);
        new MultiplyArray(list1, list2);
    }

    @Test(expected = MultiplyArray.InputContainsTwoDigitNumber.class)
    public void test_InputHavingInvalid() {
        new MultiplyArray(List.of(1, 2, 12, 3), List.of(1, 2));
    }

    @Test(expected = MultiplyArray.NegativeInputInBetweenOfNumbers.class)
    public void test_InputHavingNegativeNumberInBetween() {
        new MultiplyArray(List.of(1, 2, -1, 3), List.of(1, 2));
    }

    @Test
    public void test_twoDigitPositiveNumbers() {
        List<Integer> input1 = List.of(4, 1);
        List<Integer> input2 = List.of(1, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(4, 9, 2), actual);
    }

    @Test
    public void test_multiply() {
        List<Integer> input1 = List.of(4, 1);
        List<Integer> input2 = List.of(1, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(4, 9, 2), actual);
    }

    @Test
    public void test_multiply_2() {
        List<Integer> input1 = List.of(-9, 2, 5, 2, 1, 1);
        List<Integer> input2 = List.of(-3, 5, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(3, 2, 5, 6, 7, 4, 2, 7, 2), actual);
    }

    @Test
    public void test_multiplyFollowCommutativeProperty() {
        List<Integer> input1 = List.of(-9, 2, 5, 2, 1, 1);
        List<Integer> input2 = List.of(-3, 5, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> multiply1 = multiplyArray.multiply();

        input1 = List.of(-3, 5, 2);
        input2 = List.of(-9, 2, 5, 2, 1, 1);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> multiply2 = multiplyArray.multiply();
        Assert.assertEquals(multiply1, multiply2);
    }

    @Test
    public void test_multiplyFirstNumberLarger() {
        List<Integer> input1 = List.of(9, 9, 1, 2, 3, 4, 5, 2, 1, 2, 4);
        List<Integer> input2 = List.of(9, 9, 1, 3, 4, 5, 6);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(9, 8, 2, 6, 5, 5, 9, 8, 1, 1, 9, 9, 3, 8, 0, 5, 4, 4), actual);
    }

    @Test
    public void test_multiplySecondNumberLarger() {
        List<Integer> input1 = List.of(9, 9, 1, 3, 4, 5, 6);
        List<Integer> input2 = List.of(9, 9, 1, 2, 3, 4, 5, 2, 1, 2, 4);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(9, 8, 2, 6, 5, 5, 9, 8, 1, 1, 9, 9, 3, 8, 0, 5, 4, 4), actual);
    }

    @Test
    public void test_multiplyOfOneNegativeNumber() {
        List<Integer> input1 = List.of(-4, 1);
        List<Integer> input2 = List.of(1, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(-4, 9, 2), actual);
    }


    @Test
    public void test_multiplyOfTwoNegativeNumbers() {
        List<Integer> input1 = List.of(-4, 1);
        List<Integer> input2 = List.of(-1, 2);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(4, 9, 2), actual);
    }

    @Test
    public void test_multiplyOfTwo9sNumbers() {
        List<Integer> input1 = List.of(9, 9);
        List<Integer> input2 = List.of(9, 9);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(9, 8, 0, 1), actual);
    }

    @Test
    public void test_multiplyOfLargeNumbers() {
        List<Integer> input1 = List.of(1, 9, 3, 7, 0, 7, 7, 2, 1);
        List<Integer> input2 = List.of(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(-1, 4, 7, 5, 7, 3, 9, 5, 2, 5, 8, 9, 6, 7, 6, 4, 1, 2, 9, 2, 7), actual);
    }

    @Test
    public void test_multiplyOfDifferentLengthArray() {
        List<Integer> input1 = List.of(4, 1, 9, 2);
        List<Integer> input2 = List.of(9, 5);
        multiplyArray = new MultiplyArray(input1, input2);
        List<Integer> actual = multiplyArray.multiply();
        Assert.assertEquals(List.of(3, 9, 8, 2, 4, 0), actual);
    }
}