package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class LinkedListMerging<T extends Comparable<T>> {
    private final LinkedList<T> linkedList1;
    private final LinkedList<T> linkedList2;

    public LinkedListMerging(LinkedList<T> linkedList1, LinkedList<T> linkedList2) {
        this.linkedList1 = linkedList1;
        this.linkedList2 = linkedList2;
    }

    public LinkedList<T> mergeLinkedList() {
        SinglyLinkedListNode<T> singlyLinkedListNode = new SinglyLinkedListNode<>((T) (Integer.valueOf(10)));
        SinglyLinkedListNode<T> result = singlyLinkedListNode;
        SinglyLinkedListNode<T> first = linkedList1.getFirstNode();
        SinglyLinkedListNode<T> second = linkedList2.getFirstNode();
        while (Objects.nonNull(first) && Objects.nonNull(second)) {
            if (first.getData().compareTo(second.getData()) < 0) {
                singlyLinkedListNode.setNext(first);
                first = first.getNext();
            } else {
                singlyLinkedListNode.setNext(second);
                second = second.getNext();
            }
            singlyLinkedListNode = singlyLinkedListNode.getNext();
        }
        singlyLinkedListNode.setNext(Objects.nonNull(first) ? first : second);
        return new LinkedList<>(result.getNext());
    }
}
