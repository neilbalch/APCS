import java.util.Scanner;

public class FormulasRunner {
    public static void main(String[] args) {
        Formulas formulas = new Formulas();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        boolean exit = false;

        while(!exit) {
            System.out.println("\n\n");
            while (!(choice <= 15 && choice >= 0)) {
                System.out.println("Select a formula to run: ");
                System.out.println("0:\tExit");
                System.out.println("1:\tVolume of a Cone");
                System.out.println("2:\tVolume of a Sphere");
                System.out.println("3:\tVolume of a Cube");
                System.out.println("4:\tVolume of a Rectangular Prism");
                System.out.println("5:\tVolume of a Cylinder");
                System.out.println("6:\tArea of a Circle");
                System.out.println("7:\tArea of a Square");
                System.out.println("8:\tArea of a Rectangle");
                System.out.println("9:\tArea of a Triangle");
                System.out.println("10:\tArea of an Ellipse");
                System.out.println("11:\tLinear Momentum Calculator");
                System.out.println("12:\tHeight of Falling Object Calculator");
                System.out.println("13:\tVelocity of Falling Object Calculator");
                System.out.println("14:\tPosition Formula Calculator");
                System.out.println("15:\tAngular Speed Calculator");

                System.out.print("> ");
                choice = sc.nextInt();

                if (choice <= 15 && choice >= 0) {
                    System.out.println("Excellent! Let's go to that now!");
                } else {
                    System.out.println("EEH! Try again! (1-15)");
                }
            }

            switch(choice) {
                case 1:
                    formulas.coneVolume();
                    break;
                case 2:
                    formulas.sphereVolume();
                    break;
                case 3:
                    formulas.cubeVolume();
                    break;
                case 4:
                    formulas.rectangularPrisimVolume();
                    break;
                case 5:
                    formulas.cylindereVolume();
                    break;
                case 6:
                    formulas.circleArea();
                    break;
                case 7:
                    formulas.squareArea();
                    break;
                case 8:
                    formulas.rectangleArea();
                    break;
                case 9:
                    formulas.triangleArea();
                    break;
                case 10:
                    formulas.ellipseArea();
                    break;
                case 11:
                    formulas.linearMomentum();
                    break;
                case 12:
                    formulas.heightOfFallingObject();
                    break;
                case 13:
                    formulas.velocityOfFallingObject();
                    break;
                case 14:
                    formulas.positionFormula();
                    break;
                case 15:
                    formulas.angularSpeed();
                    break;
                case 0:
                    exit = true;
                    break;
            }

            choice = -1;
        }
    }
}
