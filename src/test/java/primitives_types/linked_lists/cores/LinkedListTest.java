package primitives_types.linked_lists.cores;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static primitives_types.linked_lists.cores.LinkedListResource.MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE;
import static primitives_types.linked_lists.cores.LinkedListResource.NULL_NODE;

public class LinkedListTest<T extends Comparable<T>> {
    private LinkedList<T> linkedList;
    private SinglyLinkedListNode firstNode;

    private void addItemsInStartList(Integer... integers) {
        List<Integer> integerList = List.of(integers);
        integerList.stream().forEach(num -> linkedList.addItemInStart((T) num));
    }

    private void addItemsInEndList(Integer... integers) {
        List<Integer> integerList = List.of(integers);
        integerList.stream().forEach(num -> linkedList.addItemInEnd((T) num));
    }

    private void assertLinkedListDataAddedInStart(SinglyLinkedListNode firstNode, Integer[] integers, List<Integer> expected) {
        linkedList = new LinkedList<>(firstNode);
        addItemsInStartList(integers);
        List<T> actual = linkedList.getList();
        assertEquals(expected, actual);
    }

    private void assertLinkedListDataAddedInEnd(SinglyLinkedListNode firstNode, Integer[] integers, List<Integer> expected) {
        linkedList = new LinkedList<>(firstNode);
        addItemsInEndList(integers);
        List<T> actual = linkedList.getList();
        assertEquals(expected, actual);
    }

    @Test(expected = LinkedList.NullNode.class)
    public void whenTryToFindNull_shouldThrowTheException() {
        firstNode = MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        linkedList.findInLinkedList(null);
    }

    @Test
    public void whenLinkedListIsEmpty_willReturnIsEmptyTrue() {
        firstNode = NULL_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void whenLinkedListIsNonEmpty_willReturnIsEmptyFalse() {
        firstNode = MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.isEmpty();
        assertFalse(actual);
    }

    @Test
    public void whenValuePresentInLinkedList_findShouldReturnTrue() {
        firstNode = MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.findInLinkedList((T) "EFG");
        assertEquals(true, actual);
    }

    @Test(expected = LinkedList.NullNode.class)
    public void whenTryToFindNullInRepeatingFirstNode_shouldThrowTheException() {
        firstNode = LinkedListResource.MULTIPLE_ITEMS_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        linkedList.findInLinkedList(null);
    }

    @Test
    public void whenValuePresentInRepeatingLinkedList_findShouldReturnTrue() {
        firstNode = LinkedListResource.MULTIPLE_ITEMS_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.findInLinkedList((T) "ABC");
        assertEquals(true, actual);
    }

    @Test
    public void whenValuePresentInSingleItemLinkedList_findShouldReturnTrue() {
        firstNode = LinkedListResource.SINGLE_ITEM_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.findInLinkedList((T) "ABC");
        assertEquals(true, actual);
    }

    @Test
    public void whenValuePresentInSingleItemLinkedList_findShouldReturnFalse_whenNoPresent() {
        firstNode = LinkedListResource.SINGLE_ITEM_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.findInLinkedList((T) "AB");
        assertEquals(false, actual);
    }

    @Test
    public void whenValueNotPresentInLinkedList_findShouldReturnFalse() {
        firstNode = MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE;
        linkedList = new LinkedList<>(firstNode);
        boolean actual = linkedList.findInLinkedList((T) "EF");
        assertEquals(false, actual);
    }

    @Test
    public void whenOneItemAddedInStartLinkedListInStart_listShouldHaveThatItem() {
        assertLinkedListDataAddedInStart(NULL_NODE, new Integer[]{1}, List.of(1));
    }

    @Test
    public void whenTwoItemsAddedInStartLinkedListInStart_listShouldHaveThoseItems() {
        assertLinkedListDataAddedInStart(NULL_NODE, new Integer[]{1, 2}, List.of(2, 1));
    }

    @Test
    public void whenMultipleItemsAddedInStartLinkedListInStart_listShouldHaveThoseItems() {
        assertLinkedListDataAddedInStart(NULL_NODE, new Integer[]{1, 2, 3, 4, 5, 6}, List.of(6, 5, 4, 3, 2, 1));
    }

    @Test
    public void whenOneItemAddedInEndLinkedListInStart_listShouldHaveThatItem() {
        assertLinkedListDataAddedInEnd(NULL_NODE, new Integer[]{1}, List.of(1));
    }

    @Test
    public void whenTwoItemsAddedInEndLinkedListInStart_listShouldHaveThoseItems() {
        assertLinkedListDataAddedInEnd(NULL_NODE, new Integer[]{1, 2}, List.of(1, 2));
    }

    @Test
    public void whenMultipleItemsAddedInEndLinkedListInStart_listShouldHaveThoseItems() {
        assertLinkedListDataAddedInEnd(NULL_NODE, new Integer[]{1, 2, 3, 4, 5, 6}, List.of(1, 2, 3, 4, 5, 6));
    }
}