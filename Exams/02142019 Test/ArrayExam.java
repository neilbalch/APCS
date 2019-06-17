import java.util.ArrayList;

public class ArrayExam {
	public void print(int[] list) {
		for(int num : list) System.out.print(num + ", ");
		System.out.println();
	}
	
	public int maxArray(int[] list) {
		int largest = list[0];
		for(int num : list) {
			if(num > largest) largest = num;
		}
		
		return largest;
	}
	
	public void scrambleArray(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int index = (int)(nums.length * Math.random());
			
			int temp = nums[i];
			nums[i] = nums[index];
			nums[index] = temp;
		}
	}
	
	public void sort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	public void print(ArrayList<Card> list) {
		for(Card item : list) System.out.print(item + ", ");
		System.out.println();
	}
	
	public void searchAndDelete(double query, ArrayList<Card> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getValue() == query) {
				list.remove(i);
				i--;
			}
		}
	}
	
	public void sort(ArrayList<Card> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = i; j < list.size(); j++) {
				if(list.get(i).getValue() > list.get(j).getValue()) {
					Card temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
}