package linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linked_lists.cores.SinglyLinkedListNode;

import static org.junit.jupiter.api.Assertions.*;
import static linked_lists.LinkedListMergingTest.linkedListOf;
import static linked_lists.LinkedListReverseSublistTest.list;

class DeleteKthNodeFromLastTest<T> {

    private DeleteKthNodeFromLast deleteKthNodeFromLast;
    private SinglyLinkedListNode singlyLinkedListNode;
    private int k;

    @BeforeEach
    void setUp() {
        singlyLinkedListNode = linkedListOf(list(6, 5, 4, 3, 2, 1));
        deleteKthNodeFromLast = new DeleteKthNodeFromLast(singlyLinkedListNode);
    }

    private void assertKthValueFromLast(int providedK, int expected) {
        deleteKthNodeFromLast.setK(providedK);
        T kthNode = (T) deleteKthNodeFromLast.getKthNode();
        assertEquals(expected, kthNode);
    }

    @Test
    void given_AnInstance_WhenKValueZeroOrNegative_ThenCreateNewInstanceOfClassThrowingException() {
        assertThrows(
                DeleteKthNodeFromLast.InvalidInput.class,
                () ->
                        new DeleteKthNodeFromLast<Integer>(singlyLinkedListNode, -1)
        );
        assertThrows(
                DeleteKthNodeFromLast.InvalidInput.class,
                () ->
                        new DeleteKthNodeFromLast<Integer>(singlyLinkedListNode, 0)
        );
    }

    @Test
    void given_AnInstance_WhenNullInputProvided_ThenCreateNewInstanceOfClassThrowingException() {
        assertThrows(
                DeleteKthNodeFromLast.NullInput.class,
                () ->
                        new DeleteKthNodeFromLast<Integer>(null, 5)
        );
    }

    @Test
    void given_AnInstance_WhenKValueMoreThanLength_ThenCreateNewInstanceOfClassThrowingException() {
        assertThrows(
                DeleteKthNodeFromLast.InvalidInput.class,
                () ->
                        new DeleteKthNodeFromLast<Integer>(singlyLinkedListNode, 7)
        );
        assertThrows(
                DeleteKthNodeFromLast.InvalidInput.class,
                () ->
                        new DeleteKthNodeFromLast<Integer>(singlyLinkedListNode, 8)
        );
    }

    @Test
    void given_AnInstance_WhenKValueEqualsKLength_ThenCreateNewInstanceOfClassThrowingException() {
        assertDoesNotThrow(
                () ->
                        new DeleteKthNodeFromLast<Integer>(singlyLinkedListNode, 6)
        );
    }

    @Test
    void given_AnInstance_WhenKeepingValidK_ThenReturnTheValue() {
        assertKthValueFromLast(1, 1);
        assertKthValueFromLast(2, 2);
        assertKthValueFromLast(3, 3);
        assertKthValueFromLast(4, 4);
        assertKthValueFromLast(5, 5);
        assertKthValueFromLast(6, 6);
    }

}