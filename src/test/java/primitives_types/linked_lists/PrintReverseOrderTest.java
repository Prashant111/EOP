package primitives_types.linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;
import static primitives_types.linked_lists.LinkedListMergingTest.linkedListOf;
import static primitives_types.linked_lists.LinkedListReverseSublistTest.list;

class PrintReverseOrderTest<T> {

    private SinglyLinkedListNode<T> singlyLinkedListNode1;
    private SinglyLinkedListNode<T> singlyLinkedListNode2;

    @BeforeEach
    void setUp() {
        singlyLinkedListNode1 = linkedListOf(list(1, 2, 3));
        singlyLinkedListNode2 = linkedListOf(list("1", "2", "3"));
    }

    private void assertPrintReverseOrder(PrintReverseOrder<T> tPrintReverseOrder, List<T> expectedList) {
        StringJoiner stringJoiner = new StringJoiner(PrintReverseOrder.SEPARATOR);
        String actual = tPrintReverseOrder.getReverseStringData();
        for (T item : expectedList) {
            stringJoiner.add(String.valueOf(item));
        }
        String expected = stringJoiner.toString();
        assertEquals(expected, actual);
    }

    @Test
    void givenAnIntegerLinkedList_whenCallingGetReverseOrder_shouldReturnReverseOrderLinkedList() {
        PrintReverseOrder<T> tPrintReverseOrder = new PrintReverseOrder<>(singlyLinkedListNode1);
        List<Integer> expectedList = list(3, 2, 1);
        assertPrintReverseOrder(tPrintReverseOrder, (List<T>) expectedList);
    }

    @Test
    void givenAStringLinkedList_whenCallingGetReverseOrder_shouldReturnReverseOrderLinkedList() {
        PrintReverseOrder<T> tPrintReverseOrder = new PrintReverseOrder<>(singlyLinkedListNode2);
        List<String> expectedList = list("3", "2", "1");
        assertPrintReverseOrder(tPrintReverseOrder, (List<T>) expectedList);
    }

    @Test
    void givenANullLinkedList_whenCallingGetReverseOrder_shouldReturnReverseOrderLinkedList() {
        PrintReverseOrder<T> tPrintReverseOrder = new PrintReverseOrder<>(null);
        List<String> expectedList = list();
        assertPrintReverseOrder(tPrintReverseOrder, (List<T>) expectedList);
    }
}