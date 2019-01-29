public class ArrayTest {
    private String[] words;

    public ArrayTest() {
        words = new String[5];
        words[0] = "cat";
        words[1] = "mouse";
        words[2] = "dog";
        words[3] = "rat";
        words[4] = "mouserat";
    }

    public void printWords() {
        System.out.println();
        for(String word : words) {
            System.out.println(word);
        }
    }

    public void swapWords(int i1, int i2) {
        String temp = words[i1];
        words[i1] = words[i2];
        words[i2] = temp;
    }
}