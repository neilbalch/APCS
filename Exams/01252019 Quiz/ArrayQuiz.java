public class ArrayQuiz {
	private int[] numList;
	
	public ArrayQuiz() {
		numList = new int[5];
		numList[0] = 2;
		numList[1] = 4;
		numList[2] = 6;
		numList[3] = 8;
		numList[4] = 10;
	}
	
	public void printList() {
		for(int i : numList) System.out.println(i);
	}
	
	public void scramble() {
		for(int i = 0; i < numList.length; i++) {
			int index = (int)(numList.length * Math.random());
			int temp = numList[i];
			numList[i] = numList[index];
			numList[index] = temp;
		}
	}
	
	public void sort() {
		for(int i = 0; i < numList.length - 1; i++) {
			for(int j = i; j < numList.length; j++) {
				if(numList[i] > numList[j]) {
					int temp = numList[i];
					numList[i] = numList[j];
					numList[j] = temp;
				}
			}
		}
	}
}