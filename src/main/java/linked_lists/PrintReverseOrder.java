package linked_lists;

import linked_lists.cores.SinglyLinkedListNode;
import strings.StringUtils;

import java.util.Objects;

public class PrintReverseOrder<T> {
    public static final String SEPARATOR = " ";
    private SinglyLinkedListNode<T> head;
    private String result;

    public PrintReverseOrder(SinglyLinkedListNode<T> head) {
        this.head = head;
        this.result = "";
    }

    public String getReverseStringData() {
        result = "";
        printReverseHelper(head);
        return result.trim();
    }

    private void printReverseHelper(SinglyLinkedListNode<T> head) {
        if (Objects.nonNull(head) && Objects.nonNull(head.getNext())) printReverseHelper(head.getNext());
        result = result.concat(Objects.nonNull(head) ? head.getData().toString() : StringUtils.EMPTY).concat(SEPARATOR);
    }
}
