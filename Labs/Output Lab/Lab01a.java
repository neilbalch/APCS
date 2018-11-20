public class Lab01a {
  public static void printBox(int width, int height) {
    String endLines = "";

    // Create bounding line string
    for(int i = 0; i < width; i++) {
      endLines += "*";
    }

    String middleLines = "";

    // Create middle line string
    middleLines += "*";
    for(int i = 0; i < width - 2; i++) {
      middleLines += " ";
    }
    middleLines += "*";

    // Print lines...
    System.out.println(endLines);
    for(int i = 0; i < height - 2; i++) {
      System.out.println(middleLines);
    }
    System.out.println(endLines);
  }

  public static void main(String[] args) {
    System.out.println("Part 1");
    System.out.println("+++++++++++++++++++++++++\n");

    // Print some boxed text, boi.
    String endLines = "+++++++++++++++++++++++++++";
    String midLines = "+++                     +++";
    String textLine = "+++       CompSci       +++";

    System.out.println(endLines);
    System.out.println(endLines);
    for(int i = 0; i < 3; i++) {
      System.out.println(midLines);
    }
    System.out.println(textLine);
    for(int i = 0; i < 3; i++) {
      System.out.println(midLines);
    }
    System.out.println(endLines);
    System.out.println(endLines);

    System.out.println();
    System.out.println("Part 2");
    System.out.println("+++++++++++++++++++++++++\n");

    // Sequentially print out each line of the ASCII Animal.
    System.out.print("   \"\"\n");
    System.out.print(" _oo\\\n");
    System.out.println("(__/ \\  _  _");
    System.out.println("   \\  \\/ \\/ \\");
    System.out.println("   (\t\t\t\t )\\");
    System.out.println("    \\_______/  \\");
    System.out.println("     [[] [[]   \'");
    System.out.println("     [[] [[]   \'");
    System.out.println();
    System.out.println("Camel with a long tail.");

    System.out.println();
    System.out.println("Part 3");
    System.out.println("+++++++++++++++++++++++++\n");

    // Generate string array of text and iterate through printing it.
    String text[] = new String[] {
      "*     *\t\t*******\t\t*      \t\t*      \t\t ***** ",
      "*     *\t\t*      \t\t*      \t\t*      \t\t*     *",
      "*******\t\t*******\t\t*      \t\t*      \t\t*     *",
      "*     *\t\t*      \t\t*      \t\t*      \t\t*     *",
      "*     *\t\t*******\t\t*******\t\t*******\t\t ***** "
    };
    for(int i = 0; i < text.length; i++) {
      System.out.println(text[i]);
    }

    System.out.println();
    System.out.println("Part 4: Challenge:");
    System.out.println("+++++++++++++++++++++++++\n");

    printBox(28, 7);
  }
}