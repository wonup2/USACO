import java.io.*;
import java.util.*;
public class angry {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("angry.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(a);
	}
		
	static void solve() {
		int min = 0;
		int max = 500000000;
		int ans = 0;
		while(min <= max) {
			int mid = (min+max)/2;

			if(f(mid)) {
				ans = mid;
				max = mid-1;
			}
			else {
				min = mid+1;
			}
		}
		out.println(ans);
	}
	
	static boolean f(int m) {
		int used = 0;
		int last = 0;
		while(last < n) {
			used++;
			int curr = last+1;
			while(curr < n && a[curr] - a[last] <= 2*m) {
				curr++;
			}
			last = curr;
		}		
		return used <= k;
	}
}