package primitives_types.linked_lists.cores;

import org.jetbrains.annotations.NotNull;

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

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }

}
