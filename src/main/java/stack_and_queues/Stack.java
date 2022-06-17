package stack_and_queues;

public class Stack<T> {
    protected T[] stackData;
    protected int capacity;
    protected int size;

    public Stack(int capacity) {
        handleExceptions(capacity);
        this.stackData = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    protected void handleExceptions(int capacity) {
        if (capacity <= 0)
            throw new InvalidCapacity();
    }

    public void push(T data) {
        if (size == capacity)
            throw new StackFull();
        this.stackData[size++] = data;
    }

    public T peek() {
        if (size == 0)
            throw new StackEmpty();
        return this.stackData[size - 1];
    }

    public T pop() {
        if (size == 0)
            throw new StackEmpty();
        return this.stackData[--size];
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public static class InvalidCapacity extends RuntimeException {
    }

    public static class StackFull extends RuntimeException {
    }

    public static class StackEmpty extends RuntimeException {
    }
}
