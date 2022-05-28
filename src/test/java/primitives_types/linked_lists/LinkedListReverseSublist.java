package primitives_types.linked_lists;

import primitives_types.linked_lists.cores.LinkedList;
import primitives_types.linked_lists.cores.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedListReverseSublist<T extends Comparable<T>> {

    private final SinglyLinkedListNode<T> firstNode;
    private final int start;
    private final int end;

    public LinkedListReverseSublist(SinglyLinkedListNode<T> firstNode, int start, int end) {
        handleExceptions(firstNode, start, end);
        this.firstNode = firstNode;
        this.start = start;
        this.end = end;
    }

    private void handleExceptions(SinglyLinkedListNode<T> firstNode, int start, int end) {
        if (Objects.isNull(firstNode))
            throw new NullInput();
        if (start < 1 || end < start)
            throw new InvalidRange();
    }

    public List<T> asList() {
        List<T> result = new ArrayList<>();
        SinglyLinkedListNode<T> iter = firstNode;
        while (Objects.nonNull(iter)) {
            result.add(iter.getData());
            iter = iter.getNext();
        }
        return result;
    }

    public SinglyLinkedListNode<T> reverseSubList() {
        SinglyLinkedListNode<T> copy = deepCopy(firstNode);
        SinglyLinkedListNode<T> iter = copy;
        SinglyLinkedListNode<T> from = null;
        SinglyLinkedListNode<T> to = null;
        for (int i = 1; i <= end + 1 && Objects.nonNull(iter); i++) {
            if (i == start - 1)
                from = iter;
            if (i == end + 1)
                to = iter;
            iter = iter.getNext();
        }
        SinglyLinkedListNode<T> first = reversePart( start == 1 ? copy : from.getNext(), to);
        if (Objects.nonNull(from))
            from.setNext(first);
        return Objects.nonNull(from) ? from : first;
    }

    private SinglyLinkedListNode<T> deepCopy(SinglyLinkedListNode<T> firstNode) {
        SinglyLinkedListNode<T> firstCopyNode = new SinglyLinkedListNode<>((T) "DUMMY");
        SinglyLinkedListNode<T> head = firstCopyNode;
        SinglyLinkedListNode<T> iter = firstNode;
        while (Objects.nonNull(iter)) {
            firstCopyNode.setNext(iter.getData());
            firstCopyNode = firstCopyNode.getNext();
            iter = iter.getNext();
        }
        return head.getNext();
    }

    private SinglyLinkedListNode<T> reversePart(SinglyLinkedListNode<T> start, SinglyLinkedListNode<T> end) {
        SinglyLinkedListNode<T> p;
        SinglyLinkedListNode<T> q = start;
        SinglyLinkedListNode<T> r = end;
        while (q != end) {
            p = q;
            q = q.getNext();
            p.setNext(r);
            r = p;
        }
        return r;
    }

    public static class NullInput extends RuntimeException {
    }

    public static class InvalidRange extends RuntimeException {
    }
}
