//© A+ Computer Science  -  www.apluscompsci.com

//scanner string example

import java.util.Scanner;

public class ScannerStrings{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        //There are issues with nextLine() and the variable sentence.  Fix it.
        //(1) What is happening that is not working correctly?
        // no new variable is being created for the second.
        //(2) What type of errors are these? runtime or syntax?
        // syntax

        System.out.print("Enter an integer :: ");
        int num = keyboard.nextInt();

        keyboard.nextLine();

        System.out.print("Enter a sentence :: ");
        String sentence = keyboard.nextLine();

        System.out.println("");

        System.out.println("Your number is :: " + num);
        System.out.println("Your sentence is :: " + sentence);

        //Add code to do the following.  Decide if you should use next() or nextLine().
        //(3) Ask the user for their favorite color, then print it out.
        //(4) Ask the user for their favorite saying, then print it out.

        System.out.print("Enter your favorite color :: ");
        String color = keyboard.nextLine();
        System.out.println("Nice, what I heard is that your favorite color is: " + color);

        System.out.print("Enter your favorite saying :: ");
        String saying = keyboard.nextLine();
        System.out.println("Nice, what I heard is that your favorite saying is: " + saying);
    }
}