import java.util.*;
import java.io.*;
 
public class CSES1085 {
	static BufferedReader in;
	static PrintWriter out;
	static int N, K, a[];
	static long T;
	
	public static void main(String[] args) throws IOException {
	
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = 0;
		a = new int[N];	
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			T+=a[i];
		}
		
		System.out.println(T);
	}
	
	static void solve() {
		long ans = 0;
		long low = 0;
		long high = T;
		long mid = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(ans);
	}
 
	static boolean check(long mid) {
		int g = 0;
		long s = 0;
		
		for(int i=0; i<N; i++) {
			if(a[i]>mid) return false;
			
			if(s+a[i] > mid) {
				g++;
				s=0;
			}
			s+=a[i];
		}
		if(s>0) g++;
		
		return g<=K;
	}
}