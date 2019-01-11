public class StringReview {
    private String myText;

    public StringReview(String myText) { this.myText = myText; }

    public void printEachChar() {
        for(int i = 0; i < myText.length(); i++)
            System.out.print(myText.charAt(i) + " ");
        System.out.println();
    }
}