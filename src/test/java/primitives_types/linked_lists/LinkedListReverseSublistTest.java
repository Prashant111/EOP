package primitives_types.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListReverseSublistTest {

    public static <T> List<T> list(T... values) {
        return List.of(values);
    }

    private <T> SinglyLinkedListNode<T> singlyLinkedList(T... values) {
        SinglyLinkedListNode<T> linkedListNode = new SinglyLinkedListNode<>((T) "DUMMY");
        SinglyLinkedListNode<T> head = linkedListNode;
        for (T val : values) {
            head.setNext(new SinglyLinkedListNode<>(val));
            head = head.getNext();
        }
        return linkedListNode.getNext();
    }

    private void assertLinkedListReverseSublist(SinglyLinkedListNode<String> inputString, int start, int end, List<String> expected) {
        SinglyLinkedListNode<String> firstNode = inputString;
        LinkedListReverseSublist linkedListReverseSublist = new LinkedListReverseSublist(firstNode, start, end);
        SinglyLinkedListNode<String> actual = linkedListReverseSublist.reverseSubList();
        assertEquals(expected, new LinkedList<>(actual).getList());
    }

    @Test
    void test_AssignTheValues() {
        assertDoesNotThrow(() -> {
            SinglyLinkedListNode<String> firstNode = new SinglyLinkedListNode<>("FIRST");
            new LinkedListReverseSublist(firstNode, 1, 1);
        });

    }

    @Test
    void whenNoInput_shouldThrowNoInputException() {
        assertThrows(LinkedListReverseSublist.NullInput.class, () -> new LinkedListReverseSublist(null, 1, 1));
    }

    @Test
    void whenEndLessThanStart_shouldThrowInvalidRangeException() {
        SinglyLinkedListNode<String> firstNode = singlyLinkedList("FIRST", "SECOND", "THIRD");
        Assertions.assertThrows(LinkedListReverseSublist.InvalidRange.class, () -> new LinkedListReverseSublist(firstNode, 2, 1));
    }

    @Test
    void whenStartLessThanOne_shouldThrowInvalidRangeException() {
        SinglyLinkedListNode<String> firstNode = singlyLinkedList("FIRST", "SECOND", "THIRD");
        Assertions.assertThrows(LinkedListReverseSublist.InvalidRange.class, () -> new LinkedListReverseSublist(firstNode, 0, 1));
    }

    @Test
    void testAddingNodes_shouldBeAPartOfAsListMethod() {
        SinglyLinkedListNode<String> firstNode = singlyLinkedList("FIRST", "SECOND", "THIRD");
        LinkedListReverseSublist linkedListReverseSublist = new LinkedListReverseSublist(firstNode, 1, 2);
        assertEquals(list("FIRST", "SECOND", "THIRD"), linkedListReverseSublist.asList());
    }

    @Test
    void test_reversingSubListInLinkedList() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 2, 3, list("FIRST", "THIRD", "SECOND", "FORTH"));
    }

    @Test
    void test_reversingSubListInLinkedList2() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 2, 4, list("FIRST", "FORTH", "THIRD", "SECOND"));
    }

    @Test
    void test_reversingSubListInLinkedList3() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 2, 9, list("FIRST", "FORTH", "THIRD", "SECOND"));
    }

    @Test
    void test_reversingSubListInLinkedList4() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 1, 4, list("FORTH", "THIRD", "SECOND", "FIRST"));
    }

    @Test
    void test_reversingSubListInLinkedList5() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 1, 9, list("FORTH", "THIRD", "SECOND", "FIRST"));
    }

    @Test
    void test_reversingSubListInLinkedList6() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 1, 2, list("SECOND", "FIRST", "THIRD", "FORTH"));
    }

    @Test
    void test_reversingSubListInLinkedList7() {
        assertLinkedListReverseSublist(singlyLinkedList("FIRST", "SECOND", "THIRD", "FORTH"), 1, 3, list("THIRD", "SECOND", "FIRST", "FORTH"));
    }
}
