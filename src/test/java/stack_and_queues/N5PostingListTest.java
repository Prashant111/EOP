package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack_and_queues.posting_element.PostingElement;

import java.util.List;

import static linked_lists.LinkedListReverseSublistTest.list;
import static org.junit.jupiter.api.Assertions.assertEquals;

class N5PostingListTest {

    private PostingElement postingElement;

    @BeforeEach
    void setUp() {
        postingElement = new PostingElement();
        postingElement.setNext(new PostingElement());
        postingElement.getNext().setNext(new PostingElement());
        postingElement.getNext().getNext().setNext(new PostingElement());

        postingElement.setJump(postingElement.getNext().getNext());
        postingElement.getNext().setJump(postingElement.getNext().getNext().getNext());
        postingElement.getNext().getNext().setJump(postingElement.getNext());
        postingElement.getNext().getNext().getJump().setJump(postingElement.getNext().getNext().getNext());
    }

    @Test
    void givenAPostingList_whenCallSetOrderMethod_thenShouldSetTheMethod() {
        N5PostingList n5PostingList = new N5PostingList(postingElement);
        n5PostingList.setOrder();
        List<Integer> actual = n5PostingList.getList();
        List<Integer> expected = list(0, 2, 1, 3);
        assertEquals(expected, actual);
    }
}