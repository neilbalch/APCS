public class MRQuiz {
	private int[][] numMatrix;
	
	public MRQuiz(int[][] list) {
		numMatrix = list;
	}
	
	public void print() {
		for(int[] row : numMatrix) {
			for(int item : row) {
				System.out.print(item + "\t");
			}
			System.out.println();
		}
	}
	
	public int count(int query) {
		int count = 0;
		for(int[] row : numMatrix) {
			for(int item : row) {
				if(item == query) count++;
			}
		}
		return count;
	}
	
	public void searchReplace(int query, int sub) {
		for(int r = 0; r < numMatrix.length; r++) {
			for(int c = 0; c < numMatrix[r].length; c++) {
				if(numMatrix[r][c] == query) numMatrix[r][c] = sub;
			}
		}
	}
}