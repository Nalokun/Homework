import java.util.Scanner;

public class Shoppinglist {
    int size;
    Itemnode head;
    Itemnode tail;

    void additem(Itemnode value) {
        Scanner in = new Scanner(System.in);
        if (value == null || value.quntity == 0) {
            return;
        }
        System.out.println("set the count you need: ");
        int count = in.nextInt();
        if (count > value.quntity || count < 0) {
            throw new OutOfMemoryError("not have engouh");
        }
        Itemnode temp = new Itemnode(0);
        temp.id = value.id;
        temp.storenumber = value.storenumber;
        temp.name = value.name;
        temp.quntity = count;
        temp.price = value.price * count;
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        value.quntity -= count;
        size++;
    }

    public Integer Return(String itemname, int quntity) {
        if (head == null) {
            return 0;
        }
        Itemnode cur = head;
        while (cur != null) {
            if (cur.name.equals(itemname)) {
                int count = 1;
                if (count > cur.quntity) {
                    System.out.println("cant find this quntity");
                    return null;
                }
                cur.quntity -= count;
                return count;
            }
            cur = cur.next;
        }

        return 0;
    }
}
