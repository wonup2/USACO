import java.util.*;
import java.io.*;

public class loan {
	static BufferedReader in;
	static PrintWriter out;
	static long N, K, M;
	
	public static void main(String[] args) throws IOException {		
		in = new BufferedReader(new FileReader("loan.in"));	
		out = new PrintWriter(new File("loan.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
	}
	
	static void solve() {
		long ans = 0;
		long low = 1;
		long high = N;
		long mid = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		out.println(ans);
	}

	static boolean check(long x) {
		long left = N;
		long days = K;
	    while(left > 0 && days > 0) {
	        long y = left / x;  
	        if (y<=M) return y*days >= left; 
	        
	        long pass = left % y + 1;
	        left -= y*pass;
	        days -= pass;
	    }
	    
	    return left <= 0; 
	}
}
