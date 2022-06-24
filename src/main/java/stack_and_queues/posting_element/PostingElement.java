package stack_and_queues.posting_element;

public class PostingElement {
    private int order;
    private PostingElement next;
    private PostingElement jump;

    public PostingElement() {
        this.order = -1;
    }

    public void setNext(PostingElement next) {
        this.next = next;
    }

    public void setJump(PostingElement jump) {
        this.jump = jump;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public PostingElement getNext() {
        return next;
    }

    public PostingElement getJump() {
        return jump;
    }
}
