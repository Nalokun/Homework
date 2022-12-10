import java.util.Scanner;

public class Itemnode {
    String name;
    String id;
    int price;
    int quntity;
    int storenumber;
    Itemnode next;

    Itemnode() {
        Scanner in = new Scanner(System.in);
        System.out.println("set id of product :");
        id = in.next();
        System.out.println("set name of product :");
        name = in.next();
        System.out.println("set price of product :");
        price = in.nextInt();
        System.out.println("set quntity of product :");
        quntity = in.nextInt();
        storenumber = id.charAt(0) - 48;
    }

    Itemnode(int k) {

    }

    @Override
    public String toString() {
        return "Itemnode{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", quntity=" + quntity +
                ", storenumber=" + storenumber +
                '}';
    }
}
