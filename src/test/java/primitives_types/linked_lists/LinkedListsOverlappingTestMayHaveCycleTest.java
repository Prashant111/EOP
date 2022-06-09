package primitives_types.linked_lists;

import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;
import static primitives_types.linked_lists.cores.LinkedListResource.NULL_NODE;

class LinkedListsOverlappingTestMayHaveCycleTest {

    private void assertOverlappingTest(boolean expected, SinglyLinkedListNode<String> first, SinglyLinkedListNode<String> second) {
        LinkedListsOverlappingMayHaveCycle linkedList = new LinkedListsOverlappingMayHaveCycle(first, second);
        assertEquals(expected, linkedList.doListsOverlap());
    }

    @Test
    void initialize_WithTwoLinkedLists() {
        assertDoesNotThrow(() ->
                new LinkedListsOverlappingMayHaveCycle(linkedListOf(list("A", "B", "C")), linkedListOf(list("D", "E", "F")))
        );
    }

    @Test
    void test_forNoOverlapping() {
        assertOverlappingTest(false,
                linkedListOf(list("A", "B", "C")),
                linkedListOf(list("D", "E", "F")));
    }

    @Test
    void test_forOverlapping() {
        SinglyLinkedListNode<String> first = linkedListOf(list("A", "B", "C"));
        SinglyLinkedListNode<String> second = linkedListOf(list("D", "E"));
        second.getNext().setNext(first.getNext().getNext());
        assertOverlappingTest(true, first, second);
    }

    @Test
    void test_forOverlappingWithFirstListHavingCycle() {
        SinglyLinkedListNode<String> first = linkedListOf(list("A", "B", "C"));
        SinglyLinkedListNode<String> second = linkedListOf(list("D", "E"));
        first.getNext().getNext().setNext(first.getNext());
        second.getNext().setNext(first.getNext().getNext());
        assertOverlappingTest(true, first, second);
    }

    @Test
    void test_forNoOverlappingWithFirstListHavingCycle() {
        SinglyLinkedListNode<String> first = linkedListOf(list("A", "B", "C"));
        SinglyLinkedListNode<String> second = linkedListOf(list("D", "E"));
        first.getNext().getNext().setNext(first.getNext());
        assertOverlappingTest(false, first, second);
    }

    @Test
    void test_forNoOverlappingWithBothListsHavingCycle() {
        SinglyLinkedListNode<String> first = linkedListOf(list("A", "B", "C"));
        SinglyLinkedListNode<String> second = linkedListOf(list("D", "E"));
        first.getNext().getNext().setNext(first.getNext());
        second.getNext().setNext(second.getNext());
        assertOverlappingTest(false, first, second);
    }

    @Test
    void test_whenFirstListIsNull() {
        assertOverlappingTest(false,
                NULL_NODE,
                linkedListOf(list("D", "E", "F")));
    }
}