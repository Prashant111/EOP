package primitives_types.linked_lists;

import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static primitives_types.linked_lists.cores.LinkedListResource.*;

class LinkedListMergingTest<T extends Comparable<T>> {

    public static final List<String> COMBINED_SORTED_LIST_1_AND_2 =
            List.of("ABC", "BED", "BFE", "CDE", "EFG", "EFG", "FGI", "GHI", "GHI");
    public static final List<String> EXPECTED_LIST_1 =
            List.of("ABC", "CDE", "EFG", "GHI");
    public static final List<String> EXPECTED_LIST_2 =
            List.of("BED", "BFE", "EFG", "FGI", "GHI");

    private void assertLinkedListMerging(List expected, SinglyLinkedListNode sortedList1, SinglyLinkedListNode sortedList2) {
        LinkedList<T> linkedList1 = new LinkedList<T>(sortedList1);
        LinkedList<T> linkedList2 = new LinkedList<T>(sortedList2);
        LinkedListMerging<T> linkedListMerging = new LinkedListMerging<>(linkedList1, linkedList2);
        LinkedList<T> actual = linkedListMerging.mergeLinkedList();
        assertEquals(expected, actual.getList());
    }

    @Test
    void mergeLinkedList() {
        assertLinkedListMerging(COMBINED_SORTED_LIST_1_AND_2, SORTED_LIST_1, SORTED_LIST_2);
    }

    @Test
    void mergeLinkedList_whenFirstNodeNull_thenShouldReturnSecondOne() {
        assertLinkedListMerging(EXPECTED_LIST_2, NULL_NODE, SORTED_LIST_2);
    }

    @Test
    void mergeLinkedList_whenSecondNodeNull_thenShouldReturnFirstOne() {
        assertLinkedListMerging(EXPECTED_LIST_1, SORTED_LIST_1, NULL_NODE);
    }

    @Test
    void mergeLinkedList_whenBothNodeNull_thenShouldReturnNull() {
        assertLinkedListMerging(List.of(), NULL_NODE, NULL_NODE);
    }
}