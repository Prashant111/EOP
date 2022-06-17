package linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linked_lists.cores.LinkedList;
import linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static linked_lists.LinkedListMergingTest.linkedListOf;
import static linked_lists.LinkedListReverseSublistTest.list;

class PivotPointTest<T extends Comparable<T>> {

    private SinglyLinkedListNode<T> singlyLinkedListNode1;
    private SinglyLinkedListNode<T> singlyLinkedListNode2;
    private T data;

    @BeforeEach
    void setUp() {
        singlyLinkedListNode1 = linkedListOf(list(11, 5, 7, 5, 11, 12));
        singlyLinkedListNode2 = linkedListOf(list(3, 2, 2, 11, 7, 5, 11));
        data = (T) Integer.valueOf(7);
    }

    private void assertPivotPoint(PivotPoint<T> input, List<Integer> expected) {
        input.transformAroundPivotNode();
        SinglyLinkedListNode<T> headNode = input.getHeadNode();
        List<T> actual = new LinkedList<T>(headNode).getList();
        assertEquals(expected, actual);
    }

    @Test
    void givenValidListAndData_whenTestForInitializingWithConstructor_thenShouldThrowNoException() {
        assertDoesNotThrow(() -> {
            new PivotPoint(singlyLinkedListNode1, data);
        });
    }

    @Test
    void givenValidListButDataNotPresent_whenTestForInitializingWithConstructor_thenShouldThrowInvalidDataException() {
        assertThrows(
                PivotPoint.InvalidInput.class,
                () -> {
                    new PivotPoint(singlyLinkedListNode1, 6);
                });
    }

    @Test
    void givenNullList_whenTestForInitializingWithConstructor_thenShouldThrowNullInputException() {
        assertThrows(
                PivotPoint.NullInput.class,
                () -> {
                    new PivotPoint(null, 6);
                });
    }

    @Test
    void givenAValidList_whenTransformMethodIsCalled_thenShouldTransformTheList() {
        assertPivotPoint(new PivotPoint<T>(singlyLinkedListNode1, data), list(5, 5, 7, 11, 11, 12));
    }

    @Test
    void givenAValidList_whenTransformMethodIsCalled_thenShouldTransformTheList2() {
        assertPivotPoint(new PivotPoint<T>(singlyLinkedListNode2, data), list(3, 2, 2, 5, 7, 11, 11));
    }
}