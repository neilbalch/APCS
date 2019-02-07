import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item(15.50, "Book"));
        list.add(new Item(999.99, "Laptop"));
        list.add(new Item(0.25, "Pencil"));

        ArrayListTest.printList(list);
        System.out.println("Scramble");
        ArrayListTest.scramble(list);
        ArrayListTest.printList(list);
        System.out.println("Sort");
        ArrayListTest.sort(list);
        ArrayListTest.printList(list);
    }
}