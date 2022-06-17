package primitives_types.linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;

class AddNumbersFromListTest {

    private SinglyLinkedListNode<Integer> list1n1;
    private SinglyLinkedListNode<Integer> list1n2;
    private SinglyLinkedListNode<Integer> list1n3;

    @BeforeEach
    void setUp() {
        list1n1 = linkedListOf(list(3, 1, 4));
        list1n2 = linkedListOf(list(7, 0, 9));
        list1n3 = linkedListOf(list(0, 2, 3, 1));
    }

    private void assertAddNumberFromList(SinglyLinkedListNode<Integer> list1, SinglyLinkedListNode<Integer> list2, SinglyLinkedListNode<Integer> sumList) {
        AddNumbersFromList addNumbersFromList = new AddNumbersFromList(list1, list2);
        SinglyLinkedListNode<Integer> integerSinglyLinkedListNode = addNumbersFromList.sumList();
        List<Integer> actual = new LinkedList<>(integerSinglyLinkedListNode).getList();
        List<Integer> expected = new LinkedList<>(sumList).getList();
        assertEquals(expected, actual);
    }

    @Test
    void givenNoInstanceOfAddNumbersFromList_whenCreatingNewInstance_thenItShouldCreateInstanceWithoutException() {
        assertDoesNotThrow(() -> new AddNumbersFromList(list1n1, list1n2));
    }

    @Test
    void givenValidNumbersProvided_whenCallingAddMethod_thenItShouldReturnCorrectlyAddedList() {
        assertAddNumberFromList(list1n1, list1n2, list1n3);
    }

    @Test
    void givenOneNullList_whenCallingAddMethod_thenItShouldReturnTheOtherList() {
        assertAddNumberFromList(null, list1n2, list1n2);
    }

    @Test
    void givenTwoNullLists_whenCallingAddMethod_thenItShouldReturnNullList() {
        assertAddNumberFromList(null, null, null);
    }
}