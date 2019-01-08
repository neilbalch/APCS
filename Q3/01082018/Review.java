public class Review {
    private int[] nums;

    public Review(int length) {
        nums = new int[length];

        for(int i = 0; i < nums.length; i++)
            nums[i] = (int)(4 * Math.random() + 2);
    }

    public void printArray() {
        for(int i : nums)
            System.out.println(i);
    }
}