import java.util.*;

public class Arrays_BinarySearch {

	public static void main(String[] args) {
		
		int a[] = {1, 4, 5, 6, 10, 11, 12, 15, 20};
		
		System.out.println(Arrays.binarySearch(a, 6)); //3
		System.out.println(Arrays.binarySearch(a, 7)); //-5
		System.out.println(Arrays.binarySearch(a, 12)); //
		
		List<Integer> b = new ArrayList<Integer>();
		
		for(int i=0; i<a.length; i++)
			b.add(a[i]);
		
		System.out.println(Collections.binarySearch(b, 13));
		System.out.println(b.indexOf(12));
		System.out.println(b.lastIndexOf(12));		
		
	}
}
