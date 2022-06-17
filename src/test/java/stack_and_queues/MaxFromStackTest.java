package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static linked_lists.LinkedListReverseSublistTest.list;
import static org.junit.jupiter.api.Assertions.*;

class MaxFromStackTest<T extends Comparable<T>> {
    private int validCapacityTwo;
    private int validCapacityTen;
    private int invalidCapacityNegative;
    private int invalidCapacityZero;

    @BeforeEach
    void setUp() {
        validCapacityTwo = 2;
        validCapacityTen = 10;
        invalidCapacityNegative = -5;
        invalidCapacityZero = 0;
    }

    private void pushToStack(MaxFromStack<T> stack, List<T> list) {
        for (T data : list)
            stack.push(data);
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithValidCapacity_thenCreateInstanceWithoutException() {
        assertDoesNotThrow(() -> new MaxFromStack(validCapacityTwo));
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithInvalidNegativeCapacity_thenThrowInvalidCapacityException() {
        assertThrows(MaxFromStack.InvalidCapacity.class,
                () -> new MaxFromStack(invalidCapacityNegative));
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithInvalidZeroCapacity_thenThrowInvalidCapacityException() {
        assertThrows(MaxFromStack.InvalidCapacity.class,
                () -> new MaxFromStack(invalidCapacityZero));
    }

    @Test
    void givenStackInstance_whenPeekDataOnEmptyStack_thenThrowStackEmptyException() {
        assertThrows(MaxFromStack.StackEmpty.class,
                () -> {
                    MaxFromStack stack = new MaxFromStack(validCapacityTwo);
                    stack.peek();
                }
        );
    }

    @Test
    void givenStackInstance_whenCallingMaxMethod_thenShouldThrowEmptyStackException() {
        assertThrows(MaxFromStack.StackEmpty.class,
                () -> {
                    MaxFromStack stack = new MaxFromStack(validCapacityTwo);
                    stack.maxData();
                }
        );
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPopOnEmptyStack_thenPopShouldThrowStackEmptyStack() {
        assertThrows(MaxFromStack.StackEmpty.class, () -> {
            MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTwo);
            pushToStack(stack, (List<T>) list("One", "Two"));
            assertEquals((T) "Two", stack.pop());
            assertEquals((T) "One", stack.pop());
            stack.pop();
        });
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenFullTheStackAndPushAfterThat_thenPushShouldThrowStackFullStack() {
        assertThrows(MaxFromStack.StackFull.class, () -> {
            MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTwo);
            pushToStack(stack, (List<T>) list("One", "Two"));
            stack.push((T) "Three");
        });
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPeekMethod_thenPeekShouldReturnTopValue() {
        MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.pop());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPeekMethodManyTimes_thenManyPeekShouldReturnSameValue() {
        MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPopMethod_thenPopShouldTakeOutTopValue() {
        MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.pop());
        assertEquals((T) "One", stack.pop());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenTestingMaxFunctionality_thenEverytimeMaxShouldReturnTrueMaxValue() {
        MaxFromStack<T> stack = new MaxFromStack<>(validCapacityTen);
        stack.push((T) Integer.valueOf(4));
        assertEquals(4, stack.maxData());

        stack.push((T) Integer.valueOf(2));
        assertEquals(4, stack.maxData());

        stack.push((T) Integer.valueOf(1));
        assertEquals(4, stack.maxData());

        stack.push((T) Integer.valueOf(8));
        assertEquals(8, stack.maxData());

        stack.push((T) Integer.valueOf(6));
        assertEquals(8, stack.maxData());

        stack.push((T) Integer.valueOf(10));
        assertEquals(10, stack.maxData());

        stack.push((T) Integer.valueOf(9));
        assertEquals(10, stack.maxData());

        stack.pop();
        assertEquals(10, stack.maxData());

        stack.pop();
        assertEquals(8, stack.maxData());

        stack.pop();
        assertEquals(8, stack.maxData());

        stack.pop();
        assertEquals(4, stack.maxData());

        stack.pop();
        assertEquals(4, stack.maxData());

        stack.pop();
        assertEquals(false, stack.isEmpty());
        assertEquals(4, stack.maxData());

        stack.pop();
        assertEquals(true, stack.isEmpty());
    }
}