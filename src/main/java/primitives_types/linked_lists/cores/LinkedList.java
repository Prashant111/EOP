package primitives_types.linked_lists.cores;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedList<T extends Comparable<T>> {
    protected SinglyLinkedListNode<T> firstNode;

    public LinkedList() {
        this.firstNode = null;
    }

    public LinkedList(SinglyLinkedListNode<T> firstNode) {
        this.firstNode = firstNode;
    }

    public boolean findInLinkedList(T item) {
        if (Objects.isNull(item))
            throw new NullNode();
        SinglyLinkedListNode<T> iter = firstNode;
        while (Objects.nonNull(iter)) {
            if (iter.getData().equals(item))
                return true;
            iter = iter.getNext();
        }
        return false;
    }

    public void addItemInStart(T data) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(data);
        node.setNext(firstNode);
        firstNode = node;
    }

    public void addItemInEnd(T data) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(data);
        if (firstNode == null)
            firstNode = node;
        else {
            SinglyLinkedListNode<T> iter = firstNode;
            while (Objects.nonNull(iter.getNext())) iter = iter.getNext();
            iter.setNext(node);
        }
    }

    public SinglyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public boolean isEmpty() {
        return Objects.isNull(firstNode);
    }

    public List<T> getList() {
        List<T> list = new ArrayList<>();
        SinglyLinkedListNode<T> iter = firstNode;
        while (Objects.nonNull(iter)) {
            list.add(iter.getData());
            iter = iter.getNext();
        }
        return list;
    }

    public static class NullNode extends RuntimeException {
    }

}
