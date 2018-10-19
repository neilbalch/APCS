public class Runner {
    public static void main(String[] args) {
        Distance dist = new Distance();

        dist.setDistance(2, 3, 6, 6);
        System.out.println(dist.getDistance());
    }
}