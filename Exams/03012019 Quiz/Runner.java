public class Runner {
	public static void main(String[] args) {
		int[][] m1 = new int[3][5];
		for(int r = 0; r < m1.length; r++) {
			for(int c = 0; c < m1[r].length; c++) {
				m1[r][c] = (int)(5 * Math.random() + 1);
			}
		}
		
		MRQuiz test = new MRQuiz(m1);
		test.print();
		System.out.println(test.count(1));
		test.searchReplace(5, 0);
		test.print();
	}
}