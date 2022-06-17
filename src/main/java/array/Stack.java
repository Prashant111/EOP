package array;

public class Stack {
    private final int[] array;
    private final int capacity;
    private int size = 0;

    public Stack(int capacity) {
        handleExceptions(capacity);
        this.array = new int[capacity];
        this.capacity = capacity;
    }

    private void handleExceptions(int capacity) {
        if (capacity < 0)
            throw new InvalidCapacity();

    }

    public void push(int num) {
        if (size == capacity)
            throw new Overflow();
        array[size++] = num;
    }

    public int pop() {
        if (size == 0)
            throw new Underflow();
        return array[--size];
    }

    public int peek() {
        if (size == 0)
            throw new DataNotFoundException();
        return array[size - 1];
    }

    public class Overflow extends RuntimeException {
    }

    public class Underflow extends RuntimeException {
    }

    public class InvalidCapacity extends RuntimeException {
    }

    public class DataNotFoundException extends RuntimeException {
    }
}
