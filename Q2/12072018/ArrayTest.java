public class ArrayTest {
    private int[] nums;

    public ArrayTest(int length) {
        nums = new int[length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (int)(5 * Math.random() + 1);
        }
    }

    public void print() {
        for(int i : nums) {
            System.out.println(i);
        }
    }

    public boolean search(int num) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num) return true;
        }

        return false;
    }
}