import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1, 2, 3, 14, 25, 26, 37};
		
		int seek = 27;
		
		int idx = Arrays.binarySearch(a, seek);
		
		if(idx < 0) {
			int lower = Math.abs(idx) - 2;
			int upper = Math.abs(idx) - 1;
			
			System.out.println("Lower bound: " + a[lower]);
			System.out.println("Upper bound: " + a[upper]);
		}
		
		
		

	}

}
