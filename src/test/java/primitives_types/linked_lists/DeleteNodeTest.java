package primitives_types.linked_lists;

import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import static org.junit.jupiter.api.Assertions.*;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;

class DeleteNodeTest {

    @Test
    void test_DeleteNodeInitialization() {
        assertDoesNotThrow(() -> {
            SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
            new DeleteNode(firstNode, firstNode.getNext());
        });
    }

    @Test
    void test_DeleteNodeLast() {
        assertThrows(DeleteNode.LastNode.class,
                () -> {
                    SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
                    new DeleteNode(firstNode, firstNode.getNext().getNext());
                });
    }

    @Test
    void test_DeleteNodeDoesNotBelongsToList() {
        assertThrows(DeleteNode.DeleteNodeNotPartOfProvidedLinkedList.class,
                () -> {
                    SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
                    SinglyLinkedListNode<String> differentList = linkedListOf(list("Different"));
                    new DeleteNode(firstNode, differentList);
                });
    }

    @Test
    void test_NodeToDeleteAsNull() {
        assertThrows(
                DeleteNode.NullInput.class,
                () -> {
                    SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
                    new DeleteNode(firstNode, null);
                });
    }

    @Test
    void test_LinkedListAsNull() {
        assertThrows(
                DeleteNode.NullInput.class,
                () -> {
                    SinglyLinkedListNode<String> nodeToDelete = linkedListOf(list("A", "B", "C"));
                    new DeleteNode(null, nodeToDelete);
                });
    }

    @Test
    void test_NodeToDeleteTest1() {
        SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
        DeleteNode deleteNode = new DeleteNode(firstNode, firstNode.getNext());
        deleteNode.delete();
        assertEquals(list("A", "C"), new LinkedList<>(firstNode).getList());
    }

    @Test
    void test_NodeToDeleteTest2() {
        SinglyLinkedListNode<String> firstNode = linkedListOf(list("A", "B", "C"));
        DeleteNode deleteNode = new DeleteNode(firstNode, firstNode);
        deleteNode.delete();
        assertEquals(list("B", "C"), new LinkedList<>(firstNode).getList());
    }
}