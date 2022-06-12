package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class EvenOddSegregation<T extends Comparable<T>> {

    private SinglyLinkedListNode<T> firstNode;

    public EvenOddSegregation(SinglyLinkedListNode<T> firstNode) {
        handleExceptions(firstNode);
        this.firstNode = firstNode;
    }

    private void handleExceptions(SinglyLinkedListNode<T> firstNode) {
        if (Objects.isNull(firstNode))
            throw new NoInput();
    }

    public void rearrange() {
        if (nodeSizeLessThanThree()) {
            return;
        }
        SinglyLinkedListNode<T> odd = firstNode;
        SinglyLinkedListNode<T> oddIterator = odd;
        SinglyLinkedListNode<T> lastOddIterator = odd;

        SinglyLinkedListNode<T> even = firstNode.getNext();
        SinglyLinkedListNode<T> evenIterator = even;

        while (Objects.nonNull(oddIterator) && Objects.nonNull(evenIterator)) {
            oddIterator.setNext(evenIterator.getNext());
            oddIterator = oddIterator.getNext();
            lastOddIterator = Objects.nonNull(oddIterator) ? oddIterator : lastOddIterator;

            if (Objects.nonNull(oddIterator)) {
                evenIterator.setNext(oddIterator.getNext());
                evenIterator = evenIterator.getNext();
            }
        }
        lastOddIterator.setNext(even);
    }

    private boolean nodeSizeLessThanThree() {
        return Objects.isNull(firstNode.getNext()) || Objects.isNull(firstNode.getNext().getNext());
    }

    public SinglyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public static class NoInput extends RuntimeException {
    }
}
