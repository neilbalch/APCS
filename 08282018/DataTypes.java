public class DataTypes {
    public static void main(String args[]) {
        //(1) What type of numbers do you think
        //the variable one, two, three, and four are?
        //(integers or decimals)
        byte one = 5;
        System.out.println(one);

        short two = 7;
        System.out.println(two);

        int three = 8;
        System.out.println(three);

        long four = 9;
        System.out.println(four);

        //(2) What type of numbers do you think the variable
        //five and six are? (integers or decimals)

        float five = 5.2f;
        System.out.println(five);

        double six = 190.34;
        System.out.println(six);


        //(3) What data type is seven?
        char seven = 'c';
        System.out.println(seven);
        System.out.println("(int)seven: " + (int)seven);

        //(4) What happens if you uncomment and run this code below?
        three = (int)7.3;
        System.out.println(three);

        //(5) What does it print below?
        //Challenge: Why doesn't it print 65?
        seven = 65;
        System.out.println(seven);


        //(6) What is the output? A number or a word?
        boolean eight = true;
        System.out.println(eight);

        //(7) What happens when you replace the variable eight with a number?
        eight = false;
        System.out.println(eight);
    }
}
