package linked_lists;

import linked_lists.cores.SinglyLinkedListNode;

import java.util.Objects;

public class AddNumbersFromList {
    private final SinglyLinkedListNode<Integer> n1HeadNode;
    private final SinglyLinkedListNode<Integer> n2HeadNode;

    public AddNumbersFromList(SinglyLinkedListNode<Integer> n1HeadNode, SinglyLinkedListNode<Integer> n2HeadNode) {
        this.n1HeadNode = n1HeadNode;
        this.n2HeadNode = n2HeadNode;
    }

    public SinglyLinkedListNode<Integer> sumList() {
        SinglyLinkedListNode<Integer> n1Iterator = n1HeadNode;
        SinglyLinkedListNode<Integer> n2Iterator = n2HeadNode;

        SinglyLinkedListNode<Integer> sumList = new SinglyLinkedListNode<>(1);
        SinglyLinkedListNode<Integer> sumIterator = sumList;

        int sum;
        int carry = 0;
        while (Objects.nonNull(n1Iterator)
                || Objects.nonNull(n2Iterator)) {
            int n1 = Objects.nonNull(n1Iterator) ? n1Iterator.getData() : 0;
            int n2 = Objects.nonNull(n2Iterator) ? n2Iterator.getData() : 0;
            sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            sumIterator.setNext(new SinglyLinkedListNode<>(sum));
            sumIterator = sumIterator.getNext();

            n1Iterator = Objects.nonNull(n1Iterator) ? n1Iterator.getNext() : null;
            n2Iterator = Objects.nonNull(n2Iterator) ? n2Iterator.getNext() : null;
        }
        if (carry > 0) {
            sumIterator.setNext(carry);
        }
        return sumList.getNext();
    }
}
