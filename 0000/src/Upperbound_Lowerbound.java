import java.util.Arrays;

public class Upperbound_Lowerbound {

	public static void main(String[] args) {

		int a[] = {1, 3, 4, 6};
		int n = Arrays.binarySearch(a,5);
		
		int upper = 0, lower = 0;
		if(n<0) {
			upper = a[n*-1-1];
			lower = a[n*-1-2];
		}
		
	
		System.out.println(n);
		System.out.println(upper+" "+lower);
		
		
	}
	public static int lowerBound(int[] array, int length, int value) {
	    int low = 0;
	    int high = length;
	    while (low < high) {
	        final int mid = (low + high) / 2;
	        if (value <= array[mid]) {
	            high = mid;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}
	public static int upperBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value >= array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
