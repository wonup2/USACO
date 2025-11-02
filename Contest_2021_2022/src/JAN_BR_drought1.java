import java.util.*;

public class JAN_BR_drought1 {
	
	static Scanner in;
	static int t, n;
	static long a[];
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		int t=in.nextInt();

	    for (int test = 0; test < t; test++) {
	        n = in.nextInt();
	        n += 2;
	        a = new long[n];
	        for (int i = 1; i < n - 1; i++)
	            a[i] = in.nextLong();
	        
	       
	    }
	}
}
