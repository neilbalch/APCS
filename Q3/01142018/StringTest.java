public class StringTest {
    private String word;

    public StringTest(String word) {
        this.word = word;
    }

    private char getFirstLetter() { return word.charAt(0); }
    private char getLastLetter() { return word.charAt(word.length() - 1); }

    public void printWordGame() {
        for(int i = 0; i < word.length(); i++) {
            if(i == 0) System.out.print(getFirstLetter() + " ");
            else if(i == word.length() - 1) System.out.print(getLastLetter());
            else System.out.print("* ");
        }
        System.out.println();
        System.out.println("Can you guess what the uncensored word is?");
    }
}
