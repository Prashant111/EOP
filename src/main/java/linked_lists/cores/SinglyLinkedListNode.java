package linked_lists.cores;

public class SinglyLinkedListNode<T> {
    private T data;
    private SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(T data) {
        this.next = new SinglyLinkedListNode<>(data);
    }

    public void setNext(SinglyLinkedListNode<T> node) {
        this.next = node;
    }

    public void setData(T data) {
        this.data = data;
    }
}
