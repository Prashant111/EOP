package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class CheckPalindromicity<T> {
    private final SinglyLinkedListNode<T> firstNode;

    public CheckPalindromicity(SinglyLinkedListNode<T> firstNode) {
        handleException(firstNode);
        this.firstNode = firstNode;
    }

    private void handleException(SinglyLinkedListNode<T> firstNode) {
        if (Objects.isNull(firstNode))
            throw new NullInput();
    }

    public boolean test() {
        SinglyLinkedListNode<T> middleNode = findMiddle();
        SinglyLinkedListNode<T> reversedSecondHalf = reverseSecondHalf(middleNode.getNext());

        SinglyLinkedListNode<T> firstHalfIterator = firstNode;
        SinglyLinkedListNode<T> secondHalfIterator = reversedSecondHalf;

        while (Objects.nonNull(firstHalfIterator) && Objects.nonNull(secondHalfIterator) && firstHalfIterator.getData().equals(secondHalfIterator.getData())) {
            firstHalfIterator = firstHalfIterator.getNext();
            secondHalfIterator = secondHalfIterator.getNext();
        }

        return (Objects.isNull(firstHalfIterator) || Objects.isNull(secondHalfIterator));
    }

    private SinglyLinkedListNode<T> reverseSecondHalf(SinglyLinkedListNode<T> firstNode) {
        SinglyLinkedListNode<T> currentNode = firstNode;
        SinglyLinkedListNode<T> backNode;
        SinglyLinkedListNode<T> prevTrackerNode = null;

        while (Objects.nonNull(currentNode)) {
            backNode = currentNode;
            currentNode = currentNode.getNext();
            backNode.setNext(prevTrackerNode);
            prevTrackerNode = backNode;
        }
        return prevTrackerNode;
    }

    private SinglyLinkedListNode<T> findMiddle() {
        SinglyLinkedListNode<T> slow = firstNode;
        SinglyLinkedListNode<T> fast = firstNode;

        while (Objects.nonNull(fast.getNext()) && Objects.nonNull(fast.getNext().getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static class NullInput extends RuntimeException {
    }
}
