import java.util.*;
import java.io.*;

public class Temp_BinarySearch {
	static BufferedReader in;
	static int N, K, T, a[];
	
	public static void main(String[] args) throws IOException {		
		in = new BufferedReader(new InputStreamReader(System.in));	
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());  //5
		K = Integer.parseInt(st.nextToken());  //3 
		T = 0;
		a = new int[N];	
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			T+=a[i];
		}
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
		int g = 1;
		long sum = 0;
		for(int i=0; i<N; i++) {
			
			sum += a[i];
			if(sum > mid) {
				g++;
				sum = a[i];
			}
		}		
		return g <= K;
	}
}
