package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class DeleteKthNodeFromLast<T> {

    private final SinglyLinkedListNode<T> singlyLinkedListNode;
    private int k;

    public DeleteKthNodeFromLast(SinglyLinkedListNode<T> singlyLinkedListNode) {
        handleLinkedListExceptions(singlyLinkedListNode);
        this.singlyLinkedListNode = singlyLinkedListNode;
    }

    public DeleteKthNodeFromLast(SinglyLinkedListNode<T> singlyLinkedListNode, int k) {
        handleExceptions(singlyLinkedListNode, k);
        this.singlyLinkedListNode = singlyLinkedListNode;
        this.k = k;
    }

    private void handleExceptions(SinglyLinkedListNode<T> singlyLinkedListNode, int k) {
        handleLinkedListExceptions(singlyLinkedListNode);
        handleKthVariableException(singlyLinkedListNode, k);
    }

    private void handleLinkedListExceptions(SinglyLinkedListNode<T> singlyLinkedListNode) {
        if (Objects.isNull(singlyLinkedListNode))
            throw new NullInput();
    }

    private void handleKthVariableException(SinglyLinkedListNode<T> singlyLinkedListNode, int k) {
        if (k <= 0 || kGreaterThanLength(singlyLinkedListNode, k))
            throw new InvalidInput();
    }

    private boolean kGreaterThanLength(SinglyLinkedListNode<T> singlyLinkedListNode, int k) {
        int count = 0;
        SinglyLinkedListNode<T> iterator = singlyLinkedListNode;
        while (Objects.nonNull(iterator)) {
            iterator = iterator.getNext();
            count++;
        }
        return count < k;
    }

    public void setK(int k) {
        handleKthVariableException(singlyLinkedListNode, k);
        this.k = k;
    }

    public T getKthNode() {
        SinglyLinkedListNode<T> forwardPointer = singlyLinkedListNode;
        SinglyLinkedListNode<T> rearPointer = singlyLinkedListNode;
        int localK = k;
        while (localK-- > 0) forwardPointer = forwardPointer.getNext();
        while (Objects.nonNull(forwardPointer)) {
            forwardPointer = forwardPointer.getNext();
            rearPointer = rearPointer.getNext();
        }
        return rearPointer.getData();
    }

    public static class NullInput extends RuntimeException {
    }
    public static class InvalidInput extends RuntimeException {
    }
}
