package linked_lists;

import linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class RemoveDuplicatesFromSortedListClass<T extends Comparable<T>> {

    private final SinglyLinkedListNode<T> firstNode;

    public RemoveDuplicatesFromSortedListClass(SinglyLinkedListNode<T> firstNode) {
        if (Objects.isNull(firstNode))
            throw new NullInput();
        this.firstNode = firstNode;

    }

    public void removeDuplicates() {
        SinglyLinkedListNode<T> iterator = firstNode;
        while (Objects.nonNull(iterator) && Objects.nonNull(iterator.getNext())) {
            if (iterator.getData().equals(iterator.getNext().getData())) {
                iterator.setNext(iterator.getNext().getNext());
            } else {
                iterator = iterator.getNext();
            }
        }
    }

    public SinglyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public static class NullInput extends RuntimeException {
    }
}
