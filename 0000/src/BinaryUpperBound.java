import java.util.Arrays;

public class BinaryUpperBound {

	public static void main(String[] args) {

		int a[] = {2, 3, 5, 7};
		
		int x = Arrays.binarySearch(a, 0);
		int y = Arrays.binarySearch(a, 6);
		System.out.println(x+" "+y);
	}

}
