import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] numbers = {0, 2, 4, 10, 12, 15};
		int index = Arrays.binarySearch(numbers, 13);
		
		System.out.println(index);
		
		int ub = 0;
		int lb = 0;
		
		//upperBound
		if(index<0) {
			ub = numbers[index*-1-1];
			lb = numbers[index*-1-2];
		}
		
		System.out.println(lb+" "+ub);
		
		int[] n2 = {0, 2, 2, 2, 12, 15};
		System.out.println(Arrays.binarySearch(n2, 2));
	}
}
