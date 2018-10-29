public class Selection {
    public static String zipcode1(int zipcode) {
        if(zipcode == 94040) {
            return "Mountain View";
        } else if(zipcode == 94115) {
            return "San Francisco";
        } else if(zipcode == 95051) {
            return "Santa Clara";
        } else {
            return "Err: Not Valid";
        }
    }

    public static String zipcode2(int zipcode) {
        String city;

        switch(zipcode) {
            case 95129:
                city = "San Jose";
                break;
            case 94607:
                city = "Oakland";
                break;
            case 95035:
                city = "Milipitas";
                break;
            default:
                city = "Err: Not Valid";
                break;
        }

        return city;
    }

    public static String zipcode3(int zipcode) {
        if(zipcode == 94301) return "Palo Alto";
        if(zipcode == 94086) return "Sunnyvale";
        if(zipcode == 95037) return "Morgan Hill";
        return "Err: Not Valid";
    }
}
