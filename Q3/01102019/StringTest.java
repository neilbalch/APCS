public class StringTest {
    private String myString;

    public StringTest(String myString) { this.myString = myString; }

    private int getLength() { return myString.length(); }

    public void printInfo() {
        System.out.println(myString);
        System.out.println("Length: " + getLength());
    }

    public void printChar(int index) { System.out.println(myString.charAt(index)); }

    public void printLocation(String search) { System.out.println(myString.indexOf(search)); }

    public int countChar(char character) {
        int count = 0;
        for(int i = 0; i < myString.length(); i++) {
            if(myString.charAt(i) == character) count++;
        }

        return count;
    }
}