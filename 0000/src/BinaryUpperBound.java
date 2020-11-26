import java.util.Arrays;

public class BinaryUpperBound {
	
	static int a[] = {2, 3, 5, 7, 8, 9, 11};
	
	public static void main(String[] args) {
		
		int x = Arrays.binarySearch(a, 5);
		int y = Arrays.binarySearch(a, 6);
		System.out.println(x+" "+y);
		
	//	System.out.println(upperBound(11));
	}

	static int upperBound(int n) {		
		int min = 0; 
		int max = a.length;
		int mid =0;
		while(min<=max) {
			mid = (min + max)/2;
			if(a[mid] == n) return mid==a.length-1? -1:a[mid+1];
			else if(a[mid]>n) max = mid - 1;
			else min = mid + 1;
		}		
		return a[min];
	}	
}
