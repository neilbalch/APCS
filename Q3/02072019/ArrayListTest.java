import java.util.ArrayList;

public class ArrayListTest {
    public static void printList(ArrayList<Item> list) {
        for(Item i : list) { System.out.println(i); }
    }

    public static void scramble(ArrayList<Item> list) {
        for(int i = 0; i < list.size(); i++) {
            int index2 = (int)(list.size() * Math.random());

            Item temp = list.get(i);
            list.set(i, list.get(index2));
            list.set(index2, temp);
        }
    }

    public static void sort(ArrayList<Item> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i; j < list.size(); j++) {
                if(list.get(i).getPrice() > list.get(j).getPrice()) {
                    Item temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}