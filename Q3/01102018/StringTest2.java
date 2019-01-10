public class StringTest2 {
    private String myText;

    public StringTest2(String myTest) { this.myText = myTest; }

    public void printEachChar() {
        for(int i = 0; i < myText.length(); i++)
            System.out.print(myText.charAt(i) + " ");
        System.out.println();
    }

    public boolean contians(String query) { return myText.indexOf(query) != -1; }

    public int countChar(char query) {
        int count = 0;

        for(int i = 0; i < myText.length(); i++) {
            if(myText.charAt(i) == query) count++;
        }

        return count;
    }
}