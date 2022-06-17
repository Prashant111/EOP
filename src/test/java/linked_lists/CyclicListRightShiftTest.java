package linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import linked_lists.cores.LinkedList;
import linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static linked_lists.LinkedListMergingTest.linkedListOf;
import static linked_lists.LinkedListReverseSublistTest.list;

class CyclicListRightShiftTest<T extends Comparable<T>> {

    private CyclicListRightShift cyclicListRightShift;
    private int k;

    @BeforeEach
    void setUp() {
        SinglyLinkedListNode<T> singlyLinkedListNode = linkedListOf(list(1, 2, 3, 4, 5, 6));
        cyclicListRightShift = new CyclicListRightShift(singlyLinkedListNode);
        cyclicListRightShift.setK(30);
    }

    private void assertCyclicShift(List<Integer> expected, CyclicListRightShift<T> cyclicListRightShift, int k) {
        cyclicListRightShift.setK(k);
        cyclicListRightShift.performIntendedOperation();
        SinglyLinkedListNode<T> firstNode = cyclicListRightShift.getFirstNode();
        List<T> actual = new LinkedList<T>(firstNode).getList();
        assertEquals(expected, actual);
    }

    @Test
    void givenNoInstance_whenCreateInstance_thenCreateInstanceWithoutException() {
        assertDoesNotThrow(() -> cyclicListRightShift);
    }

    @Test
    void givenNoInstance_whenCreateInstanceFromNullLinkedList_thenCreateInstanceWithException() {
        assertThrows(
                CyclicListRightShift.NullInput.class,
                () -> {
                    CyclicListRightShift<T> cyclicListRightShift = new CyclicListRightShift<>(null);
                    cyclicListRightShift.setK(3);
                }
        );
    }

    @Test
    void givenASinglyOneElementLinkedListAndAnyK_whenPerformRotateOperation_thenListShouldRemainsSame() {
        CyclicListRightShift<T> cyclicListRightShift = new CyclicListRightShift<>(linkedListOf(list(1)));
        assertCyclicShift(list(1), cyclicListRightShift, 20);
    }


    @Test
    void givenASinglyLinkedListAndValidK_whenPerformRotateOperation_thenListChangedAccordingly() {
        assertCyclicShift(list(3, 4, 5, 6, 1, 2), cyclicListRightShift, 2);
    }

    @Test
    void givenASinglyLinkedListAndValidK_whenPerformRotateOperation_thenListChangedAccordingly2() {
        assertCyclicShift(list(1, 2, 3, 4, 5, 6), cyclicListRightShift, 0);
    }

    @Test
    void givenASinglyLinkedListAndValidK_whenPerformRotateOperation_thenListChangedAccordingly3() {
        assertCyclicShift(list(1, 2, 3, 4, 5, 6), cyclicListRightShift, 0);
    }

    @Test
    void givenASinglyLinkedListAndValidK_whenPerformRotateOperation_thenListChangedAccordingly4() {
        assertCyclicShift(list(1, 2, 3, 4, 5, 6), cyclicListRightShift, 6);
    }

    @Test
    void givenASinglyLinkedListAndValidK_whenPerformRotateOperation_thenListChangedAccordingly5() {
        assertCyclicShift(list(3, 4, 5, 6, 1, 2), cyclicListRightShift, 8);
    }

}