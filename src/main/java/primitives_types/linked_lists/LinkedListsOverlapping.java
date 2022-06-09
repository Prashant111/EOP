package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class LinkedListsOverlapping<T> {

    private final SinglyLinkedListNode<T> first;
    private final SinglyLinkedListNode<T> second;

    public LinkedListsOverlapping(SinglyLinkedListNode<T> first, SinglyLinkedListNode<T> second) {
        this.first = first;
        this.second = second;
    }

    public boolean doListsOverlap() {
        if (Objects.isNull(first) || Objects.isNull(second))
            return false;

        SinglyLinkedListNode<T> firstIterator = first;
        SinglyLinkedListNode<T> secondIterator = second;

        while (Objects.nonNull(firstIterator.getNext()))
            firstIterator = firstIterator.getNext();

        while (Objects.nonNull(secondIterator.getNext()))
            secondIterator = secondIterator.getNext();

        return Objects.equals(firstIterator, secondIterator);
    }
}
