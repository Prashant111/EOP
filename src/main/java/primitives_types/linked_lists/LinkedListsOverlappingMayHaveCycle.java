package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListsOverlappingMayHaveCycle<T> {

    private final SinglyLinkedListNode<T> first;
    private final SinglyLinkedListNode<T> second;

    public LinkedListsOverlappingMayHaveCycle(SinglyLinkedListNode<T> first, SinglyLinkedListNode<T> second) {
        this.first = first;
        this.second = second;
    }

    public boolean doListsOverlap() {
        if (Objects.isNull(first) || Objects.isNull(second))
            return false;
        Set<SinglyLinkedListNode<T>> firstListNodes = getAllNodesInList(first);
        Set<SinglyLinkedListNode<T>> secondListNodes = getAllNodesInList(second);

        firstListNodes.retainAll(secondListNodes);
        return !firstListNodes.isEmpty();
    }

    private Set<SinglyLinkedListNode<T>> getAllNodesInList(SinglyLinkedListNode<T> first) {
        Set<SinglyLinkedListNode<T>> allNodes = new HashSet<>();
        SinglyLinkedListNode<T> iter = first;
        while (iter != null && !allNodes.contains(iter)) {
            allNodes.add(iter);
            iter = iter.getNext();
        }
        return allNodes;
    }
}
