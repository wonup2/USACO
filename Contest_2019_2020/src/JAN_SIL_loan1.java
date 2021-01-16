//Plug-in 해서 반이라도 맞자.

import java.util.*;
import java.io.*;

public class JAN_SIL_loan1 {
	static BufferedReader in;
	static PrintWriter out;
	static long N,M,K;
		
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("loan.in"));
		PrintWriter out = new PrintWriter(new File("loan.out"));
	    N = in.nextLong();
	    K = in.nextLong();
	    M = in.nextLong();
		long low = 1, high = 1000000000000l;
		long ans = 0l;
		while (low <= high) {
		    long mid = (low + high)/2;
		    if (check(mid)) {
		    	ans = mid;
		    	low = mid+1; 
		    }
		    else high = mid-1;
		}		
		out.println(ans);
		out.close();
		in.close();
	}
	
	static boolean check(long x) {
		long g = 0;
		for(int i=0; i<K; i++) {
			long y = (N-g)/x;  
		    if (y <= M) { 
		    	g+=(K-i)*M; 
		    	break;
		    }
		    g+=y;		    
		}
		return g>= N ;
	}
}
