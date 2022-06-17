package linked_lists;

import org.junit.jupiter.api.Test;
import linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static linked_lists.cores.LinkedListResource.NULL_NODE;

class LinkedListCyclicityTest {
    @Test
    void whenLinkedListIsNull_CyclicityNotPresent() {
        LinkedListCyclicity linkedListCyclicity = new LinkedListCyclicity(NULL_NODE);
        boolean actual = linkedListCyclicity.containsCycle();
        assertEquals(false, actual);
    }

    @Test
    void test_CyclicityPresent() {
        SinglyLinkedListNode<String> firstNode = LinkedListMergingTest.linkedListOf(List.of("A", "B", "C"));
        firstNode.getNext().getNext().setNext(firstNode.getNext());
        LinkedListCyclicity linkedListCyclicity = new LinkedListCyclicity(firstNode);
        boolean actual = linkedListCyclicity.containsCycle();
        assertEquals(true, actual);
    }

    @Test
    void test_CyclicityNotPresent() {
        SinglyLinkedListNode<String> firstNode = LinkedListMergingTest.linkedListOf(List.of("A", "B", "C"));
        LinkedListCyclicity linkedListCyclicity = new LinkedListCyclicity(firstNode);
        boolean actual = linkedListCyclicity.containsCycle();
        assertEquals(false, actual);
    }
}
