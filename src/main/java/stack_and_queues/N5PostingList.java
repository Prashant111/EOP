package stack_and_queues;

import stack_and_queues.posting_element.PostingElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class N5PostingList {
    private final PostingElement head;

    public N5PostingList(PostingElement head) {
        this.head = head;
    }

    public List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        PostingElement iterator = head;
        while (Objects.nonNull(iterator)) {
            list.add(iterator.getOrder());
            iterator = iterator.getNext();
        }
        return list;
    }

    public void setOrder() {
        setOrderHelper(head, 0);
    }

    private int setOrderHelper(PostingElement head, int order) {
        if (postingElementNotVisited(head)) {
            head.setOrder(order++);
            order = setOrderHelper(head.getJump(), order);
            order = setOrderHelper(head.getNext(), order);
        }
        return order;
    }

    private boolean postingElementNotVisited(PostingElement head) {
        return Objects.nonNull(head) && orderNotInitialized(head.getOrder());
    }

    private boolean orderNotInitialized(int order) {
        return order == -1;
    }
}
