import java.util.ArrayList;

public class ArrayListTest {
    public static void scramble(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
           int index2 = (int)(list.size() * Math.random());

           int temp = list.get(i);
           list.set(i, list.get(index2));
           list.set(index2, temp);
        }
    }

    public static void sort(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            int min = i;

            for(int j = i; j < list.size(); j++) {
                if(list.get(j) < list.get(min)) min = j;
            }

            if(min != i) {
                int temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
    }

    public static void print(ArrayList<Integer> list) {
        for(int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}