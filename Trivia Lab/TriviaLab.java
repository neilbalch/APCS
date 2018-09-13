import java.util.Scanner;

public class TriviaLab {
    public static void main(String[] args) {
        System.out.println("APCS Trivia Game!!!!!\n\n");
        Scanner sc = new Scanner(System.in);

        String answer_s = "";
        double correct_answer_d = 0.0;
        double answer_d = 0.0;

        int score = 0;

        System.out.print("Pick a category: Math or (Geo)graphy... ");
        answer_s = sc.next();
        if(answer_s.toLowerCase().equals("Math".toLowerCase())) {
            System.out.println("Math it is!!");

            System.out.println("\n\nCurrent Score: " + score);
            int height = 0 + (int)(Math.random() * (10 - 0));
            int base = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the area of a triangle with height=" + height + " and base=" + base + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(0.5 * base * height * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            int radius = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the area of a circle with radius=" + radius + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(Math.PI * Math.pow(radius, 2) * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            radius = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the circumference of a circle with radius=" + radius + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(2 * Math.PI * radius * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            radius = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the volume of a sphere with radius=" + radius + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(4 / 3  * Math.PI * Math.pow(radius, 3) * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            radius = 0 + (int)(Math.random() * (10 - 0));
            height = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the volume of a cone with radius=" + radius + "and height=" + height + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(height / 3 * Math.PI * Math.pow(radius, 2) * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            int length = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the volume of a cube with side length=" + length + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(Math.pow(length, 3) * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            int axis_a = 0 + (int)(Math.random() * (10 - 0));
            int axis_b = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the area of an ellipse with axis_a=" + axis_a + " and axis_b=" + axis_b + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(Math.PI * axis_a * axis_b * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            length = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the area of a hexagon with side length=" + length + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(3 * Math.sqrt(3) / 2 * Math.pow(length, 2) * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            int a = 0 + (int)(Math.random() * (10 - 0));
            int b = 0 + (int)(Math.random() * (10 - 0));
            height = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the volume of a pyramid with base length=" + a + "," + b + " and height=" + height + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(a * b * height / 3 * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\nCurrent Score: " + score);
            radius = 0 + (int)(Math.random() * (10 - 0));
            height = 0 + (int)(Math.random() * (10 - 0));
            System.out.print("What is the volume of a cylinder with base length=" + radius + " and height=" + height + "? ");
            answer_d = sc.nextDouble();
            correct_answer_d = Math.round(Math.PI * Math.pow(radius, 2) * height * 100.0) / 100.0;
            if(answer_d == correct_answer_d) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: " + correct_answer_d);
            }

            System.out.println("\n\n\nNice! You got a score of " + score + "/10, a % correct of " + score/10.0);
        } else if (answer_s.toLowerCase().equals("geo".toLowerCase())) {
            System.out.println("Geography it is!!");

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("What is the name of the capital of California? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Sacramento".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Sacramento");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("What is the name of the capital of Arkansas? ");
            sc.nextLine();
            answer_s = sc.nextLine();
            if(answer_s.toLowerCase().equals("Little Rock".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Little Rock");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("What is the name of the capital of New York? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Albany".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Albany");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("In which state is the Grand Canyon? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Arizona".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Arizona");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("In which US State is Niagra Falls? ");
            sc.nextLine();
            answer_s = sc.nextLine();
            if(answer_s.toLowerCase().equals("New York".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: New York");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("What is the name of the capital of Idaho? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Biose".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Boise");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("Which country share the world's longest international border with the US? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Canada".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Canada");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("What is the name of our planet's largest hot desert? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Sahara".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Sahara");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("Which pole has the Arctic Ocean? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("North".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: North");
            }

            System.out.println("\n\nCurrent Score: " + score);
            System.out.print("Which continent has the Cape of Good Hope? ");
            answer_s = sc.next();
            if(answer_s.toLowerCase().equals("Africa".toLowerCase())) {
                System.out.println("Yea! You got it right!");
                score++;
            } else {
                System.out.println("Agh, you didn't get it. The answer was: Africa");
            }

            System.out.println("\n\n\nNice! You got a score of " + score + "/10, a % correct of " + score/10.0);
        } else {
            System.out.println("Well, you sure are a jolly good fellow!");
        }
    }
}