import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Mainlinkedlist {
    int size;
    Storenode head;
    Storenode tail;
    Shoppinglist cart;

    Mainlinkedlist() {
        cart = new Shoppinglist();
    }

    public static void main(String[] args) {
        Mainlinkedlist m = new Mainlinkedlist();
        Scanner in = new Scanner(System.in);
        m.addstore();
        m.addstore();
        m.addstore();
        char n;
        while (true) {
            String name = "";
            String id = "";
            System.out.println("choice of of this: 1:addi\n 2:buy\n 3:return\n 4:exist");
            n = in.next().charAt(0);
            switch (n) {
                case '1':
                    Itemnode item1 = new Itemnode();
                    m.additem(item1).store.additem(item1);
                    break;
                case '2':
                    System.out.println("set name of item need to buy :");
                    name = in.next();
                    System.out.println("set id of item need to buy :");
                    id = in.next();
                    m.cart.additem(m.search(name, id));
                    System.out.println();
                    break;
                case '3':
                    System.out.println("set name of item need to rutern :");
                    name = in.next();
                    System.out.println("set id of item need to return :");
                    int q = in.nextInt();
                    if (m.search(name, null) == null) {
                        continue;
                    }
                    m.search(name, null).quntity += m.cart.Return(name, q);
                    break;
                case '4':
                    System.out.println("bay!!");
                    return;

                default:
                    System.out.println("plz choice of of this: 1:addi\n 2:buy\n 3:return\n 4:exist");

            }
        }

    }

    public Itemnode search(String name, String id) {
        int c = id.charAt(0) - 49;// تحدد طابق فيو ايتم
        if (c >= size) {
            throw new OutOfMemoryError("ist here this iteam");
        }
        Storenode cur = head;
        if (cur == null) {
            return null;
        }
        while (c-- > 0) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
        }
        Itemnode cur2 = cur.store.head;
        while (cur2 != null) {
            if (cur2.id.equals(id) || cur2.name.equals(name)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    public double purchase() {
        double pur = 0;
        Itemnode c = cart.head;
        while (c != null) {
            if (c.quntity <= 0) {
                continue;
            }
            pur += c.price;
            c = c.next;
        }
        return pur;
    }

    void addstore() {
        Storenode temp = new Storenode();
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    Storenode additem(Itemnode value) {
        int c = value.storenumber - 1;
        if (c >= size) {
            throw new OutOfMemoryError("isnt here this number store");
        }
        Storenode cur = head;
        while (c-- > 0) {
            cur = cur.next;
        }
        return cur;
    }
}