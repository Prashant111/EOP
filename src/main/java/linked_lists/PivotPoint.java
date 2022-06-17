package linked_lists;

import linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class PivotPoint<T extends Comparable<T>> {
    private SinglyLinkedListNode<T> headNode;
    private T data;

    public PivotPoint(SinglyLinkedListNode<T> headNode, T data) {
        handleExceptions(headNode, data);
        this.headNode = headNode;
        this.data = data;
    }

    private void handleExceptions(SinglyLinkedListNode<T> headNode, T data) {
        if (Objects.isNull(headNode))
            throw new NullInput();
        boolean matched = false;
        SinglyLinkedListNode<T> iterator = headNode;
        while (Objects.nonNull(iterator)) {
            if (iterator.getData() == data) {
                matched = true;
                break;
            }
            iterator = iterator.getNext();
        }

        if (!matched)
            throw new InvalidInput();
    }

    public void transformAroundPivotNode() {
        SinglyLinkedListNode<T> lessHeader = new SinglyLinkedListNode<>((T) Integer.valueOf(0));
        SinglyLinkedListNode<T> equalHeader = new SinglyLinkedListNode<>((T) Integer.valueOf(0));
        SinglyLinkedListNode<T> greaterHeader = new SinglyLinkedListNode<>((T) Integer.valueOf(0));
        SinglyLinkedListNode<T> lessIterator = lessHeader;
        SinglyLinkedListNode<T> equalIterator = equalHeader;
        SinglyLinkedListNode<T> greaterIterator = greaterHeader;

        SinglyLinkedListNode<T> iterator = headNode;
        while (Objects.nonNull(iterator)) {
            if (iterator.getData().compareTo(data) < 0) {
                lessIterator.setNext(iterator);
                lessIterator = lessIterator.getNext();
            } else if (iterator.getData().compareTo(data) == 0) {
                equalIterator.setNext(iterator);
                equalIterator = equalIterator.getNext();
            } else {
                greaterIterator.setNext(iterator);
                greaterIterator = greaterIterator.getNext();
            }
            iterator = iterator.getNext();
        }
        greaterIterator.setNext((SinglyLinkedListNode<T>) null);
        equalIterator.setNext(greaterHeader.getNext());
        lessIterator.setNext(equalHeader.getNext());

        headNode = lessHeader.getNext();
    }

    public SinglyLinkedListNode<T> getHeadNode() {
        return headNode;
    }

    public static class NullInput extends RuntimeException {
    }

    public static class InvalidInput extends RuntimeException {
    }
}
