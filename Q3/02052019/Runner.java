import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            list.add((int)(10 * Math.random() + 1));
        }

        ArrayListTest.print(list);
        ArrayListTest.scramble(list);
        System.out.println();
        ArrayListTest.print(list);

        ArrayListTest.sort(list);
        System.out.println();
        ArrayListTest.print(list);
    }
}