public class ModEx {
    public void checkOddOrEven(int num) {
        if(num % 2 == 0) {
            System.out.println("Yup, it's even.");
        } else {
            System.out.println("Nope, it's odd.");
        }
    }

    public void checkPrime(int num) {
        Boolean isPrime = true;

        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                isPrime = false;
            }
        }

        System.out.println(isPrime ? "Yup, " + num + " is prime." : "Nope, " + num + " isn't prime.");
    }
}
