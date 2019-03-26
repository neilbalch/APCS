public class Runner {
    public static void main(String[] args) {
        MVHS school = new MVHS("Mountain View High School", "3535 Truman Ave");
        System.out.println(school.getName());
        System.out.println(school.getAddress());
    }
}