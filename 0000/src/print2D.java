
public class print2D {

	public static void main(String[] args) {
		int[][] a = new int[5][5];
		printArr(a);
	}

	static void printArr(int[][] a) {
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
