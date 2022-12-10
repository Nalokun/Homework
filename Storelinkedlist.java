public class Storelinkedlist {
    int size;
    Itemnode head;
    Itemnode tail;

    Storelinkedlist() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean additem(Itemnode value) {
        Itemnode cur = head;
        while (cur != null) {
            if (cur == value) {
                cur.quntity += value.quntity;
                return false;
            }
            cur = cur.next;
        }
        if (size == 0) {
            head = tail = value;
        } else {
            tail.next = value;
            tail = value;
        }
        size++;
        return true;
    }
}
