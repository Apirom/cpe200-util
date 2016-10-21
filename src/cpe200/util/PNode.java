package cpe200.util;

public class PNode {
    public Object data;
    public PNode next, prev;

    /**
     * Constructor for the PNode object
     */
    public PNode() { next = prev = null; }

    /**
     * Constructor for the PNode object
     * @param data  data object
     * @param next  reference to the next PNode
     * @param prev  reference to the previous PNode
     */
    public PNode(Object data, PNode next, PNode prev) {
        this.data = data;
        this.next=next;
        this.prev=prev;
    }
}
