package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class LinkedListCyclicity<T extends Comparable> {

    private final SinglyLinkedListNode<T> firstNode;

    public LinkedListCyclicity(SinglyLinkedListNode<T> firstNode) {
        this.firstNode = firstNode;
    }

    public boolean containsCycle() {
        if (Objects.isNull(firstNode))
            return false;
        SinglyLinkedListNode<T> slow = firstNode;
        SinglyLinkedListNode<T> fast = firstNode;
        while(Objects.nonNull(slow) && Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast)
                break;
        }
        return fast == slow && Objects.nonNull(fast);
    }
}
