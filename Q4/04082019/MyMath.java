public class MyMath {
    public void countDown(int num) {
        if(num > 0) {
            System.out.println(num);
            countDown(num - 1);
        }
    }

    public void countUp(int num) {
        if(num > 0) {
            countUp(num - 1);
            System.out.println(num);
        }
    }

    public int factorial(int num) {
        if(num > 1) {
            return num * factorial(num - 1);
        } else return num;
    }
}