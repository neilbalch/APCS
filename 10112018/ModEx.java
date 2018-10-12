public class ModEx {
    private int number;

    public ModEx(int number) {
        this.number = number;
    }

    public void numCheck() {
        if(number % 5 == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}