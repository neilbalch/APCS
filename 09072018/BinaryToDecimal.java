public class BinaryToDecimal {
    public static void main(String[] args) {
        int binary = 101;
        int working_binary = binary;
        int decimal = 0;

        for(int power = 0; power < Integer.toString(binary).length(); power++) {
            // If LSB is 1
            if(working_binary % 10 == 1) {
                decimal += 1 * Math.pow(2, power);
            }

            // Remove LSB
            working_binary /= 10;
        }

        System.out.println(binary + " in decimal is: " + decimal);
    }
}