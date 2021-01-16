import java.util.*;
import java.io.*;

public class Temp_BinarySearch {
	static BufferedReader in;
	static PrintWriter out;
	static int N, M, a[];
	
	public static void main(String[] args) throws IOException {		
		in = new BufferedReader(new InputStreamReader(System.in));	
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {	
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new int[N];	
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) a[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solve() {
		int ans = 0;
		int low = 0;
		int high = 100;
		int mid = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				low = mid+1;
				//high = mid-1;
			}
			else {
				//low = mid+1;
				high = mid-1;
			}
		}
		out.println(ans);
	}

	static boolean check(int mid) {
		return true;
	}
}
