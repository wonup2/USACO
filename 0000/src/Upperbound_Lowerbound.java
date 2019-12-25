
public class Upperbound_Lowerbound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
