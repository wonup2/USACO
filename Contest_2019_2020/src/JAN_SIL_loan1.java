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
		long low = 1, high = N;
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
		
		long remain = N; 
		long day = K;
		while(day > 0 && remain >0) {
			
			long y = remain/x;  
		    if (y <= M) return M * day >= remain;
		    
		    long same = ;
		    day -= same;
		    remain -= same*y;		    
		}
		return remain <=0;  //day<=0
	}
}
