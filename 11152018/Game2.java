public class Game2 {
    private int secret;

    public Game2() {
        this.secret = (int)(Math.random() * 99 + 1);
    }

    public int getNumber() {
        return secret;
    }
}