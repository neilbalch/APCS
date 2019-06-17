import java.util.ArrayList;

public class Test {
	public void printTable(int[][] list) {
		for(int r = 0; r < list.length; r++) {
			for(int c = 0; c < list[r].length; c++) {
				System.out.print(list[r][c] + "\t");
			}
			System.out.println();
		}
	}
	
	public int findSmallest(int[][] list) {
		int smallest = list[0][0];
		for(int r = 0; r < list.length; r++) {
			for(int c = 0; c < list[r].length; c++) {
				if(list[r][c] < smallest) smallest = list[r][c];
			}
		}
		return smallest;
	}
	
	public void printProfileList(ArrayList<Profile> profiles) {
		for(int i = 0; i < profiles.size(); i++) {
			System.out.println(profiles.get(i));
		}
	}
	
	public void sortProfileList(ArrayList<Profile> profiles) {
		for(int i = 0; i < profiles.size() - 1; i++) {
			for(int j = i + 1; j < profiles.size(); j++) {
				if(profiles.get(j).getAge() > profiles.get(i).getAge()) {
					Profile temp = profiles.get(i);
					profiles.set(i, profiles.get(j));
					profiles.set(j, temp);
				}
			}
		}
	}
	
	public double averageAge(ArrayList<Profile> profiles) {
		int ageSum = 0;
		for(int i = 0; i < profiles.size(); i++) {
			ageSum += profiles.get(i).getAge();
		}
		
		return (double)ageSum / profiles.size();
	}
	
	public String getPigLatin(String input) {
		return input.substring(1) + input.charAt(0) + "ay";
	}
}