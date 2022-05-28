package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class LinkedListsOverlapping {

    private final SinglyLinkedListNode<String> first;
    private final SinglyLinkedListNode<String> second;

    public LinkedListsOverlapping(SinglyLinkedListNode<String> first, SinglyLinkedListNode<String> second) {
        this.first = first;
        this.second = second;
    }

    public Object doListsOverlap() {
        if (Objects.isNull(first) || Objects.isNull(second))
            return false;

        SinglyLinkedListNode<String> firstIterator = first;
        SinglyLinkedListNode<String> secondIterator = second;

        while (Objects.nonNull(firstIterator.getNext()))
            firstIterator = firstIterator.getNext();

        while (Objects.nonNull(secondIterator.getNext()))
            secondIterator = secondIterator.getNext();

        return Objects.equals(firstIterator, secondIterator);
    }
}
