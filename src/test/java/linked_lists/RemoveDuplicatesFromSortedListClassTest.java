package linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linked_lists.cores.LinkedList;
import linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static linked_lists.LinkedListMergingTest.linkedListOf;
import static linked_lists.LinkedListReverseSublistTest.list;

class RemoveDuplicatesFromSortedListClassTest<T extends Comparable<T>> {

    private SinglyLinkedListNode<T> singlyLinkedListNode;
    private RemoveDuplicatesFromSortedListClass<T> removeDuplicatesFromSortedListClass;

    @BeforeEach
    void setUp() {
        singlyLinkedListNode = linkedListOf(list("1", "1", "2", "3", "3"));
        removeDuplicatesFromSortedListClass = new RemoveDuplicatesFromSortedListClass<T>(singlyLinkedListNode);
    }

    private void assertRemoveDuplicated(List<T> inputList, List<T> expected) {
        removeDuplicatesFromSortedListClass = new RemoveDuplicatesFromSortedListClass(linkedListOf(inputList));
        removeDuplicatesFromSortedListClass.removeDuplicates();
        List<T> list = new LinkedList<T>(removeDuplicatesFromSortedListClass.getFirstNode()).getList();
        assertEquals(expected, list);
    }

    @Test
    void givenNoInstance_whenNewInstanceCreated_thenCreateNewInstanceWithoutException() {
        assertDoesNotThrow(() -> new RemoveDuplicatesFromSortedListClass(singlyLinkedListNode));
    }

    @Test
    void givenNoInstance_whenNullInstanceCreated_thenThrowInvalidInput() {
        assertThrows(
                RemoveDuplicatesFromSortedListClass.NullInput.class,
                () -> new RemoveDuplicatesFromSortedListClass(null));
    }

    @Test
    void givenLinkedList_whenAskedToRemoveDuplicates_thenDuplicatesShouldBeRemoved() {
        assertRemoveDuplicated((List<T>) list("1", "1", "2", "3", "3"), (List<T>) list("1", "2", "3"));
        assertRemoveDuplicated((List<T>) list("1", "1", "2", "2", "2", "3", "3"), (List<T>) list("1", "2", "3"));
        assertRemoveDuplicated((List<T>) list(1, 23, 30, 30, 30, 30, 40, 45, 45), (List<T>) list(1, 23, 30, 40, 45));
        assertRemoveDuplicated((List<T>) list(1), (List<T>) list(1));
    }

}