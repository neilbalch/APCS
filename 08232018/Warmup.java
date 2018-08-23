public class Warmup {
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
    printBox(4, 4);
  }
}