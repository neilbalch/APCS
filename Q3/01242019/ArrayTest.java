public class ArrayTest {
    private int[] nums;

    public ArrayTest(int length) {
        nums = new int[length];
        for(int i = 0; i < nums.length; i++) nums[i] = (int)(10 * Math.random() + 1);
    }

    public void printArray() {
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void scramble() {
        for(int i = 0; i < nums.length; i++) {
            int index2 = (int)(nums.length * Math.random());

            int temp = nums[i];
            nums[i] = nums[index2];
            nums[index2] = temp;
        }
    }

    public void sort() {
        // Bubble Sort
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;
            int current = i;

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) min = j;
            }

            if(min != current) {
                // swap elements
                int temp = nums[current];
                nums[current] = nums[min];
                nums[min] = temp;
            }
        }
    }
}