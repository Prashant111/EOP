package primitives_types.array;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class StackTest {

    private Stack stack;

    private void pushToStack(Integer... integers) {
        List<Integer> list = list(integers);
        list.stream().forEach(num -> stack.push(num));
    }

    private List<Integer> popFromStack(int count) {
        return IntStream
                .range(0, count)
                .boxed()
                .map(index -> stack.pop())
                .collect(Collectors.toList());
    }

    private int peek() {
        return stack.peek();
    }

    private List<Integer> list(Integer... nums) {
        return List.of(nums);
    }

    private void assertStackOperation(int capacity, Integer[] pushedElements, int countedPop, Integer[] expected) {
        stack = new Stack(capacity);
        pushToStack(pushedElements);
        List<Integer> actual = popFromStack(countedPop);
        assertEquals(list(expected), actual);
    }

    @Test(expected = Stack.InvalidCapacity.class)
    public void test_invalidCapacity() {
        new Stack(-10);

    }

    @Test(expected = Stack.DataNotFoundException.class)
    public void test_peekNoEmptyInput() {
        stack = new Stack(0);
        stack.peek();
    }

    @Test(expected = Test.None.class)
    public void whenFillUpToBorder_shouldThrowNoException() {
        stack = new Stack(3);
        pushToStack(5, 6, 7);
    }

    @Test(expected = Stack.Overflow.class)
    public void whenFillAboveBorder_shouldThrowException() {
        stack = new Stack(3);
        pushToStack(5, 6, 7, 8);
    }

    @Test(expected = Stack.Underflow.class)
    public void whenTakeOutMoreThanPresentElement_shouldThrowException() {
        stack = new Stack(3);
        pushToStack(5);
        popFromStack(2);
    }

    @Test
    public void whenSinglePush_returnSameOutputOnPop() {
        assertStackOperation(5, new Integer[]{5, 10}, 1, new Integer[]{10});
    }

    @Test
    public void whenTwoElementsPushAndPopOneItem_returnTheLast() {
        assertStackOperation(5, new Integer[]{5, 10, 15}, 2, new Integer[]{15, 10});
    }

    @Test
    public void whenMultipleElementsPushedAndPoppedAllItems_returnAllInReverseOrder() {
        assertStackOperation(6, new Integer[]{20, 10, 8, 5, 2, 1}, 6, new Integer[]{1, 2, 5, 8, 10, 20});
    }

    @Test
    public void whenMultipleElementsPushedAndPeeked_returnAllInReverseOrder() {
        stack = new Stack(10);
        pushToStack(1, 2, 34, 4, 5, 6);
        assertEquals(6, peek());
        assertEquals(6, peek());
        popFromStack(1);
        assertEquals(5, peek());
        assertEquals(5, peek());
        pushToStack(10);
        assertEquals(10, peek());
        assertEquals(10, peek());
        popFromStack(4);
        assertEquals(2, peek());
        assertEquals(2, peek());
        assertEquals(2, peek());
        popFromStack(1);
        assertEquals(1, peek());
        assertEquals(1, peek());
        assertEquals(1, peek());
    }

}