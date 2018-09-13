import java.util.Scanner;

public class Compare2 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter in a number: ");
        int number = kb.nextInt();
        if( number == 9 ){
            System.out.println("The number is 9");
        }

        //It is recommended that you use .equals when comparing strings
        //as it is meant to compare the text between two strings.
        //This will work for older versions of Java.
        System.out.println("Enter in a word: ");
        String text = kb.next();
        if( text.equals("Hello") ){
            System.out.println("The text is Hello");
        }

        //1) What is the difference in the if-statement when you compare numbers and String?
        // incompatible type error, won't work

        //2) What happens if you try to compare a number with the following code? why?
        /*
        if( number = 99 ){
            System.out.println("The number is 99");
        }
        */
        // Compiler will try to set number to = 99, not compare it to 99. Syntax error

        //3) What happens if you try to compare a number with the following code? why?
        /*
        if( number == 8 );{
            System.out.println("The number is 8");
        }
        */
        // Should work.
    }
}