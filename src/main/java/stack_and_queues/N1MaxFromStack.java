package stack_and_queues;

public class N1MaxFromStack<T extends Comparable<T>> {
    private MaxCustomObject<T>[] stackData;
    private int capacity;
    private int size;

    public N1MaxFromStack(int capacity) {
        handleExceptions(capacity);
        this.capacity = capacity;
        this.stackData = new MaxCustomObject[capacity];
    }

    private void handleExceptions(int capacity) {
        if (capacity <= 0)
            throw new InvalidCapacity();
    }


    public void push(T data) {
        if (size == capacity)
            throw new StackFull();
        T maxData = max(data);
        this.stackData[size++] = new MaxCustomObject<>(data, maxData);
    }

    private T max(T data) {
        if (size == 0)
            return data;
        T lastMaxData = stackData[size - 1].getMaxData();
        return data.compareTo(lastMaxData) > 0 ? data : lastMaxData;
    }

    public T peek() {
        if (size == 0)
            throw new StackEmpty();
        return this.stackData[size - 1].getData();
    }

    public T pop() {
        if (size == 0)
            throw new StackEmpty();
        return this.stackData[--size].getData();
    }

    public T maxData() {
        if (size == 0)
            throw new StackEmpty();
        return this.stackData[size - 1].getMaxData();
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
