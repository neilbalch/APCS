import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(1));
        list.add(new Card(2));
        list.add(new Card(3));
        list.add(new Card(4));

        for(int i = 0; i < list.size(); i++) {
            int index2 = (int)(list.size() * Math.random());

            Card temp = list.get(i);
            list.set(i, list.get(index2));
            list.set(index2, temp);
        }

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}