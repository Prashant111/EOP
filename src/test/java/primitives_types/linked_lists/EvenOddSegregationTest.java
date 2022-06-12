package primitives_types.linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;

class EvenOddSegregationTest<T extends Comparable<T>> {

    private EvenOddSegregation<T> evenOddSegregation;
    private List<T> nullList;
    private List<T> singleElementList;
    private List<T> twoElementList;
    private List<T> threeElementList;
    private List<T> fourElementList;
    private List<T> evenSizedList;
    private List<T> oddSizedList;


    @BeforeEach
    void setUp() {
        nullList = null;
        singleElementList = (List<T>) list(1);
        twoElementList = (List<T>) list(1, 2);
        threeElementList = (List<T>) list(1, 2, 3);
        fourElementList = (List<T>) list(1, 2, 3, 4);
        evenSizedList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8);
        oddSizedList = (List<T>) list(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    private void assertEvenOddOrder(List<T> inputList, List<T> expected) {
        SinglyLinkedListNode<T> linkedList = linkedListOf(inputList);
        setLinkedListInEvenOdd(linkedList);
        evenOddSegregation.rearrange();
        List<T> actual = new LinkedList<>(evenOddSegregation.getFirstNode()).getList();
        assertEquals(expected, actual);
    }

    private void setLinkedListInEvenOdd(SinglyLinkedListNode<T> singlyLinkedList) {
        evenOddSegregation = new EvenOddSegregation<>(singlyLinkedList);
    }

    @Test
    void givenNoInstance_whenCreateNewInstance_thenCreateNewInstanceOfEvenOdd() {
        assertDoesNotThrow(() -> setLinkedListInEvenOdd(linkedListOf(singleElementList)));
    }

    @Test
    void givenNoInstance_whenCreateNewInstanceOfNull_thenThrowNoInputException() {
        assertThrows(EvenOddSegregation.NoInput.class,
                () -> setLinkedListInEvenOdd(linkedListOf(nullList)));
    }

    @Test
    void givenSingleSizedEvenOddList_whenCallingExecuteMethod_thenListShouldBeSame() {
        assertEvenOddOrder(singleElementList, singleElementList);
    }

    @Test
    void givenTwoSizedEvenOddList_whenCallingExecuteMethod_thenListShouldBeSame() {
        assertEvenOddOrder(twoElementList, twoElementList);
    }

    @Test
    void givenThreeSizedEvenOddList_whenCallingExecuteMethod_thenListShouldBeTransformed() {
        assertEvenOddOrder(threeElementList, (List<T>) list(1, 3, 2));
    }

    @Test
    void givenFourSizedEvenOddList_whenCallingExecuteMethod_thenListShouldBeSame() {
        assertEvenOddOrder(fourElementList, (List<T>) list(1, 3, 2, 4));
    }

    @Test
    void givenEvenSizedEvenOddList_whenCallingExecuteMethod_thenShouldRearrangeListInEvenOddOrder() {
        assertEvenOddOrder(evenSizedList, (List<T>) list(1, 3, 5, 7, 2, 4, 6, 8));
    }

    @Test
    void givenOddSizedEvenOddList_whenCallingExecuteMethod_thenShouldRearrangeListInEvenOddOrder() {
        assertEvenOddOrder(oddSizedList, (List<T>) list(1, 3, 5, 7, 9, 2, 4, 6, 8));
    }
}