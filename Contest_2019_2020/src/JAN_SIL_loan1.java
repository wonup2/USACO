import java.util.*;
import java.io.*;

public class JAN_SIL_loan1 {
	static BufferedReader in;
	static PrintWriter out;
	static long N,M,K;
	
	static long cdiv(long a, long b) {
		return (a+b-1)/b;
	}
	
	static boolean ok(long mid) {
		long res = 0;
		long day = 0;
		long G = 0;
		long day1 = 0;
		while (true) {
			long y = (N-G)/mid;  
		    if (y < M) { day1 = K-day; break;}
		    G+=y;
		    day++;
		}
		
		

		return G+(day1*M)>= N ;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("loan.in"));
		PrintWriter out = new PrintWriter(new File("loan.out"));
	    N = in.nextLong();
	    K = in.nextLong();
	    M = in.nextLong();
		long low = 1, high = N;
		long ans = 0l;
		while (low < high) {
		    long mid = (low + high)/2;
		    if (ok(mid)) {
		    	ans = mid;
		    	low = mid+1; 
		    }
		    else high = mid-1;
		}		
		out.println(ans);
		out.close();
		in.close();
	}
}
