package primitives_types.linked_lists.cores;

public class LinkedListResource {
    private static LinkedList linkedList;

    public static final SinglyLinkedListNode NULL_NODE = null;
    public static final SinglyLinkedListNode SINGLE_ITEM_NODE = new SinglyLinkedListNode("ABC");
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE = getMultipleStringsNonRepeatingItems();
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_REPEATING_FIRST_NODE = getMultipleStringsRepeatingItems();
    public static final SinglyLinkedListNode SORTED_LIST_1 = getSortedStringList1();
    public static final SinglyLinkedListNode SORTED_LIST_2 = getSortedStringList2();

    private LinkedListResource() {
    }

    private static <T extends Comparable<T>> void addItemsToLinkedList(LinkedList<T> linkedList, T... data) {
        for (T val : data)
            linkedList.addItemInEnd(val);
    }

    private static SinglyLinkedListNode getGenericLinkedList(String... strings) {
        linkedList = new LinkedList<>();
        addItemsToLinkedList(linkedList, strings);
        SinglyLinkedListNode firstNode = linkedList.getFirstNode();
        return firstNode;
    }

    private static SinglyLinkedListNode getMultipleStringsNonRepeatingItems() {
        return getGenericLinkedList("ABC", "CDE", "EFG", "GHI");
    }

    private static SinglyLinkedListNode getMultipleStringsRepeatingItems() {
        return getGenericLinkedList("ABC", "CDE", "EFG", "ABC", "GHI");
    }

    private static SinglyLinkedListNode getSortedStringList1() {
        return getGenericLinkedList("ABC", "CDE", "EFG", "GHI");
    }

    private static SinglyLinkedListNode getSortedStringList2() {
        return getGenericLinkedList("BED", "BFE", "EFG", "FGI", "GHI");
    }
}
