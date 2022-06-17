package linked_lists;

import linked_lists.LinkedListMerging;
import org.junit.jupiter.api.Test;
import linked_lists.cores.LinkedList;
import linked_lists.cores.SinglyLinkedListNode;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static linked_lists.cores.LinkedListResource.*;

class LinkedListMergingTest<T extends Comparable<T>> {

    public static final List<String> COMBINED_STRING_SORTED_LIST_1_AND_2 =
            List.of("ABC", "BED", "BFE", "CDE", "EFG", "EFG", "FGI", "GHI", "GHI");
    public static final List<String> EXPECTED_STRING_LIST_1 =
            List.of("ABC", "CDE", "EFG", "GHI");
    public static final List<String> EXPECTED_STRING_LIST_2 =
            List.of("BED", "BFE", "EFG", "FGI", "GHI");

    public static final List<Integer> COMBINED_INTEGER_SORTED_LIST_1_AND_2 =
            List.of(1, 2, 3, 4, 5, 6, 7);
    public static final List<Integer> EXPECTED_INTEGER_LIST_1 =
            List.of(1, 4, 5);
    public static final List<Integer> EXPECTED_INTEGER_LIST_2 =
            List.of(2, 3, 6, 7);

    private void assertLinkedListMerging(List<T> expected, SinglyLinkedListNode<T> sortedList1, SinglyLinkedListNode<T> sortedList2) {
        LinkedList<T> linkedList1 = new LinkedList<>(sortedList1);
        LinkedList<T> linkedList2 = new LinkedList<>(sortedList2);
        LinkedListMerging<T> linkedListMerging = new LinkedListMerging<>(linkedList1, linkedList2);
        LinkedList<T> actual = linkedListMerging.mergeLinkedList();
        assertEquals(expected, actual.getList());
    }

    public static <T> SinglyLinkedListNode linkedListOf(List<T> values) {
        if (Objects.isNull(values))
            return null;
        if (values.size() == 0)
            return new SinglyLinkedListNode(List.of());
        SinglyLinkedListNode<T> head = new SinglyLinkedListNode<>(firstValue(values));
        SinglyLinkedListNode<T> iter = head;
        for (T value : values) {
            iter.setNext(new SinglyLinkedListNode<>(value));
            iter = iter.getNext();
        }
        return head.getNext();
    }

    private static <T> T firstValue(List<T> startingNode) {
        return startingNode.get(0);
    }

    @Test
    void mergeLinkedList() {
        assertLinkedListMerging((List<T>) COMBINED_STRING_SORTED_LIST_1_AND_2, linkedListOf((List<T>) EXPECTED_STRING_LIST_1), linkedListOf((List<T>) EXPECTED_STRING_LIST_2));
    }

    @Test
    void mergeLinkedList_whenFirstNodeNull_thenShouldReturnSecondOne() {
        assertLinkedListMerging((List<T>) EXPECTED_STRING_LIST_2, NULL_NODE, linkedListOf((List<T>) EXPECTED_STRING_LIST_2));
    }

    @Test
    void mergeLinkedList_whenSecondNodeNull_thenShouldReturnFirstOne() {
        assertLinkedListMerging((List<T>) EXPECTED_STRING_LIST_1, linkedListOf((List<T>) EXPECTED_STRING_LIST_1), NULL_NODE);
    }

    @Test
    void mergeIntegerLinkedList() {
        assertLinkedListMerging((List<T>) COMBINED_INTEGER_SORTED_LIST_1_AND_2, linkedListOf((List<T>) EXPECTED_INTEGER_LIST_1), linkedListOf((List<T>) EXPECTED_INTEGER_LIST_2));
    }

    @Test
    void mergeIntegerLinkedList_whenFirstNodeNull_thenShouldReturnSecondOne() {
        assertLinkedListMerging((List<T>) EXPECTED_INTEGER_LIST_2, NULL_NODE, linkedListOf((List<T>) EXPECTED_INTEGER_LIST_2));
    }

    @Test
    void mergeIntegerLinkedList_whenSecondNodeNull_thenShouldReturnFirstOne() {
        assertLinkedListMerging((List<T>) EXPECTED_INTEGER_LIST_1, linkedListOf((List<T>) EXPECTED_INTEGER_LIST_1), NULL_NODE);
    }

    @Test
    void mergeLinkedList_whenBothNodeNull_thenShouldReturnNull() {
        assertLinkedListMerging(List.of(), NULL_NODE, NULL_NODE);
    }
}