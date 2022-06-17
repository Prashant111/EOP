package linked_lists;

import linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class DeleteNode<T> {

    private final SinglyLinkedListNode<T> firstNode;
    private final SinglyLinkedListNode<T> nodeToDelete;

    public DeleteNode(SinglyLinkedListNode<T> firstNode, SinglyLinkedListNode<T> nodeToDelete) {
        handleException(firstNode, nodeToDelete);
        this.firstNode = firstNode;
        this.nodeToDelete = nodeToDelete;
    }

    private void handleException(SinglyLinkedListNode<T> firstNode, SinglyLinkedListNode<T> nodeToDelete) {
        if (Objects.isNull(firstNode))
            throw new NullInput();

        if (Objects.isNull(nodeToDelete))
            throw new NullInput();

        SinglyLinkedListNode<T> iter = firstNode;
        while (iter != null && iter != nodeToDelete) iter = iter.getNext();

        if (Objects.isNull(iter))
            throw new DeleteNodeNotPartOfProvidedLinkedList();

        if(Objects.isNull(nodeToDelete.getNext())) {
            throw new LastNode();
        }
    }

    public void delete() {
        nodeToDelete.setData(nodeToDelete.getNext().getData());
        nodeToDelete.setNext(nodeToDelete.getNext().getNext());
    }

    public SinglyLinkedListNode<T> getFirstNode() {
        return firstNode;
    }

    public static class NullInput extends RuntimeException {
    }
    public static class DeleteNodeNotPartOfProvidedLinkedList extends RuntimeException {
    }

    public static class LastNode extends RuntimeException {
    }
}
