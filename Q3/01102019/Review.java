public class Review {
    private int[] nums;

    public Review(int length) {
        nums = new int[length];
        for(int i = 0; i < nums.length; i++)
            nums[i] = (int)(101 * Math.random() + 1);
    }

    public void printArray() {
        for(int i : nums)
            System.out.println(i);
    }

    public int getLargest() {
        int largest_num = 0;
        for (int i : nums) {
            if (i > largest_num) largest_num = i;
        }

        return largest_num;
    }
}