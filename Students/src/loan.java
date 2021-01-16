import java.util.*;
import java.io.*;

public class loan {
	static BufferedReader in;
	static PrintWriter out;
	static long N, K1, M;
	
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
		K1 = Long.parseLong(st.nextToken());
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
		  long g = 0;
		  long K = K1;
	        while(K>0 && g<N) {
	            long y = (N-g) /x;
	            if (y<M) {
	                long dayLeft = (N-g+M-1)/M;
	                if(dayLeft <=K) return true;
	                else return false;
	            }
	            long z = N-x*y;
	            long numD = (z-g)/y +1;
	            if(numD > K) {
	                numD = K;
	            }
	            g+= y * numD;
	            K-= numD;
	        }
	        if(K<0 || g<N) return false;
	        return true;
	}
}
