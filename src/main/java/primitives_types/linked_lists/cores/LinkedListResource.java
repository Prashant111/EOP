package primitives_types.linked_lists.cores;

public class LinkedListResource {
    public static final SinglyLinkedListNode NULL_NODE = null;
    public static final SinglyLinkedListNode SINGLE_ITEM_NODE = new SinglyLinkedListNode("ABC");
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE = getMultipleStringsNonRepeatingItems();
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_REPEATING_FIRST_NODE = getMultipleStringsRepeatingItems();

    private LinkedListResource() {
    }

    private static <T extends Comparable<T>> void addItemsToLinkedList(LinkedList<T> linkedList, T... values) {
        for (T val : values)
            linkedList.addItemInEnd(val);
    }

    private static <T extends Comparable<T>> SinglyLinkedListNode<T> getGenericLinkedList(T... values) {
        LinkedList<T> linkedList = new LinkedList<>();
        addItemsToLinkedList(linkedList, values);
        return linkedList.getFirstNode();
    }

    private static SinglyLinkedListNode<String> getMultipleStringsNonRepeatingItems() {
        return getGenericLinkedList("ABC", "CDE", "EFG", "GHI");
    }

    private static SinglyLinkedListNode<String> getMultipleStringsRepeatingItems() {
        return getGenericLinkedList("ABC", "CDE", "EFG", "ABC", "GHI");
    }
}
