package stack_and_queues;

public class MaxCustomObject<T extends Comparable<T>> {
    private T data;
    private T maxData;

    public MaxCustomObject(T data, T maxData) {
        this.data = data;
        this.maxData = maxData;
    }

    public T getData() {
        return data;
    }

    public T getMaxData() {
        return maxData;
    }
}
