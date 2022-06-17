package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static linked_lists.LinkedListReverseSublistTest.list;
import static org.junit.jupiter.api.Assertions.*;

class StackTest<T> {

    private int validCapacityTwo;
    private int invalidCapacityNegative;
    private int invalidCapacityZero;

    @BeforeEach
    void setUp() {
        validCapacityTwo = 2;
        invalidCapacityNegative = -5;
        invalidCapacityZero = 0;
    }

    private void pushToStack(Stack<T> stack, List<T> list) {
        for (T data : list)
            stack.push(data);
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithValidCapacity_thenCreateInstanceWithoutException() {
        assertDoesNotThrow(() -> new Stack(validCapacityTwo));
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithInvalidNegativeCapacity_thenThrowInvalidCapacityException() {
        assertThrows(Stack.InvalidCapacity.class,
                () -> new Stack(invalidCapacityNegative));
    }

    @Test
    void givenNoStackInstance_whenCreatingStackWithInvalidZeroCapacity_thenThrowInvalidCapacityException() {
        assertThrows(Stack.InvalidCapacity.class,
                () -> new Stack(invalidCapacityZero));
    }

    @Test
    void givenStackInstance_whenPeekDataOnEmptyStack_thenThrowStackEmptyException() {
        assertThrows(Stack.StackEmpty.class,
                () -> {
                    Stack stack = new Stack(validCapacityTwo);
                    stack.peek();
                }
        );
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPopOnEmptyStack_thenPopShouldThrowStackEmptyStack() {
        assertThrows(Stack.StackEmpty.class, () -> {
            Stack<T> stack = new Stack<>(validCapacityTwo);
            pushToStack(stack, (List<T>) list("One", "Two"));
            assertEquals((T) "Two", stack.pop());
            assertEquals((T) "One", stack.pop());
            stack.pop();
        });
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenFullTheStackAndPushAfterThat_thenPushShouldThrowStackFullStack() {
        assertThrows(Stack.StackFull.class, () -> {
            Stack<T> stack = new Stack<>(validCapacityTwo);
            pushToStack(stack, (List<T>) list("One", "Two"));
            stack.push((T)"Three");
        });
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPeekMethod_thenPeekShouldReturnTopValue() {
        Stack<T> stack = new Stack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.pop());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPeekMethodManyTimes_thenManyPeekShouldReturnSameValue() {
        Stack<T> stack = new Stack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
        assertEquals((T) "Two", stack.peek());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingPopMethod_thenPopShouldTakeOutTopValue() {
        Stack<T> stack = new Stack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals((T) "Two", stack.pop());
        assertEquals((T) "One", stack.pop());
    }

    @Test
    void givenStackInstanceWithDataAvailable_whenCallingIsEmptyMethod_thenMethodShouldReturnValidValues() {
        Stack<T> stack = new Stack<>(validCapacityTwo);
        pushToStack(stack, (List<T>) list("One", "Two"));
        assertEquals(false,stack.isEmpty());
        stack.pop();
        assertEquals(false,stack.isEmpty());
        stack.pop();
        assertEquals(true,stack.isEmpty());
    }



}

