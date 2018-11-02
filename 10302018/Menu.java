public class Menu {
    public static String selectMenu1(int choice) {
        if(choice == 1) return "A";
        else if(choice == 2) return "B";
        else if(choice == 3) return "C";
        else return "Err: Invalid Option";
    }

    public static String selectMenu2(int choice) {
        switch(choice) {
            case 1:
                return "X";
            case 2:
                return "Y";
            case 3:
                return "Z";
            default:
                return "Err: Invalid Option";
        }
    }
}