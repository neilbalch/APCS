import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Card> list = new ArrayList<Card>();
        list.add(new Card(1, "S"));
        list.add(new Card(3, "H"));
        list.add(new Card(10, "D"));

        System.out.println(list);
    }
}