package primitives_types.linked_lists.cores;

public class LinkedListResource {
    private static LinkedList linkedList;

    public static final SinglyLinkedListNode NULL_NODE = null;
    public static final SinglyLinkedListNode SINGLE_ITEM_NODE = new SinglyLinkedListNode("ABC");
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_NON_REPEATING_FIRST_NODE = getMultipleStringsNonRepeatingItems();
    public static final SinglyLinkedListNode MULTIPLE_ITEMS_REPEATING_FIRST_NODE = getMultipleStringsRepeatingItems();

    private LinkedListResource() {
    }

    private static SinglyLinkedListNode getMultipleStringsNonRepeatingItems() {
        linkedList = new LinkedList<>();
        addItemsToLinkedList(linkedList, "ABC", "CDE", "EFG", "GHI");
        return linkedList.getFirstNode();
    }

    private static <T> SinglyLinkedListNode<T> getMultipleStringsRepeatingItems() {
        linkedList = new LinkedList<>();
        addItemsToLinkedList(linkedList, "ABC", "CDE", "EFG", "ABC", "GHI");
        return linkedList.getFirstNode();
    }

    private static <T> void addItemsToLinkedList(LinkedList<T> linkedList, T... data) {
        for (T val : data)
            linkedList.addItemInEnd(val);
    }
}
