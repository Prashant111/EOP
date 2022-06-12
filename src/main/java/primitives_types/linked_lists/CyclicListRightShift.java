package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class CyclicListRightShift<T> {

    private SinglyLinkedListNode<T> firstNode;
    private int k;

    public CyclicListRightShift(SinglyLinkedListNode<T> firstNode) {
        if (Objects.isNull(firstNode))
            throw new NullInput();
        this.firstNode = firstNode;
    }

    public void performIntendedOperation() {
        int len = findLengthOfLinkedList();
        SinglyLinkedListNode<T> lastNode = getLastNode();
        int transformedK = len > 0 ? k % len : 0;
        SinglyLinkedListNode<T> iterator = firstNode;
        if (transformedK > 0) {
            lastNode.setNext(firstNode);
            while (--transformedK > 0)
                iterator = iterator.getNext();
            firstNode = iterator.getNext();
            iterator.setNext((SinglyLinkedListNode<T>) null);
        }
    }

    private SinglyLinkedListNode<T> getLastNode() {
        SinglyLinkedListNode<T> iterator = firstNode;
        while (Objects.nonNull(iterator.getNext())) iterator = iterator.getNext();
        return iterator;
    }

    private int findLengthOfLinkedList() {
        SinglyLinkedListNode<T> iterator = firstNode;
        int length = 0;
        while (Objects.nonNull(iterator)) {
            iterator = iterator.getNext();
            length++;
        }
        return length;
    }

    public void setK(int k) {
        this.k = k;
    }

    public SinglyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public static class NullInput extends RuntimeException {
    }
}
