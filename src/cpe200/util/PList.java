package cpe200.util;

public class PList {

    /**
     * Constructor for the PList object
     */
    public PList() { head = tail = null; }

    /**
     * Inserts the data object at the head of the list.
     *
     * @param data the data object to be inserted
     */
    public void pushToHead(Object data) {
        head = new PNode(data, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    /**
     * Pushes the data object at the end of the list.
     *
     * @param data the data object to be inserted
     */
    public void pushToTail(Object data) {
        tail = new PNode(data,null, tail);
        if (head==null)
            head = tail;
        else
            tail.prev.next = tail;
        size++;
    }

    /**
     * Returns the data object located at the head of the list
     * and remove it from the list.
     *
     * @return  the data object at the head of the list
     */
    public Object popHead() {
        Object data=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return data;
    }

    /**
     * Returns the data object located at the end of the list
     * and remove it from the list.
     *
     * @return  the data object at the end of the list
     */
    public Object popTail() {
        Object data=tail.data;
        PNode tmp = tail;

        if (tail==head)
            tail = head = null;
        else {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }

        size--;

        return data;
    }

    /**
     * Removes the first data object which is equal to the specified object from the list.
     * The method starts looking for object from the head of the list.
     *
     * @param data the specified data object to be removed from the list
     * @return      returns true if successfully removed, otherwise returns false
     */
    public boolean remove(Object data) {

        PNode tmp = head, tmp2;

        while (tmp != null) {
            if (tmp.data.equals(data)) {
                if (tmp==head) {
                    popHead();
                } else if (tmp==tail) {
                    popTail();
                } else {
                    tmp2 = tmp.prev;
                    tmp2.next = tmp.next;
                    tmp.next.prev = tmp2;
                    size--;
                }
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    /**
     * Returns the data object at idx location from head of the list
     *
     * @param idx   location of the data object from head of the list (zero index)
     * @return      the data object at idx location
     */
    public Object elementAt(int idx) {
        int i=0;
        PNode tmp = head;

        if (idx>=0 && idx<size) {
            while (i != idx) {
                tmp = tmp.next;
                i++;
            }

            return tmp.data;
        } else
            return null;
    }

    /**
     * Searches for the specified data object in the list
     *
     * @param data the data object to search for
     * @return      returns true if found a data object with the same content,
     *              otherwise returns false
     */
    public boolean found(Object data) {
        PNode tmp = head;

        while (tmp != null) {
            if (tmp.data.equals(data))
                return true;
            tmp = tmp.next;
        }

        return false;
    }

    /**
     * Removes the data object at idx location from head of the list
     *
     * @param idx   location of the data object from head of the list (zero index)
     * @return      returns true if successfully removed the data, otherwise returns false
     */
    public boolean removeAt(int idx) {
        if (idx>=0 && idx<size) {
            if (idx == 0) {
                popHead();
            } else if (idx == (size - 1)) {
                popTail();
            } else {
                int i=0;
                PNode tmp = head, tmp2;
                while (i != idx) {
                    tmp = tmp.next;
                    i++;
                }

                tmp2 = tmp.prev;
                tmp2.next = tmp.next;
                tmp.next.prev = tmp2;
                size--;

            }
            return true;

        } else
            return false;
    }

    /**
     * Searches for the specified data object in the list

     * @param data  the data object to search for
     * @return      returns the idx location of the data from head of the list
     */
    public int foundAt(Object data) {
        int idx=0;
        PNode tmp = head;

        while (tmp != null) {
            if (tmp.data == data)
                return idx;
            tmp = tmp.next;
            idx++;
        }

        return -1;
    }

    /**
     * Checks for empty list
     *
     * @return returns true if the list is empty and returns false if the list is not empty
     */
    public boolean isEmpty() { return (head == null); }

    /**
     * Prints data objects in the list from head to tail
     * @deprecated
     */
    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * Prints data objects in the list from tail to head
     * @deprecated
     */
    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    /**
     * Returns the number of data objects stored in the list
     * @return  returns the current size of the list
     */
    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}

