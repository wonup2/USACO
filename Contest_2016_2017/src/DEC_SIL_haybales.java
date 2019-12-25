import java.util.*;
import java.io.*;
public class DEC_SIL_haybales {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, q, a[];
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("haybales.in"));
		out = new PrintWriter(new PrintWriter("haybales.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());	
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	public static void solve() throws IOException {
	//	System.out.println(lower(4));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int ans = lower(e) - lower(s-1);
			sb.append(ans).append("\n");
		}
		out.print(sb.toString());
	}
	public static int lower(int n) {
		if(n<a[0]) return 0;
		int low = 0;
	    int high = a.length-1;
	    while (low <= high) {
	        int mid = (low + high) / 2;
	        if(n==a[mid]) return mid+1;
	        else if (n < a[mid]) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return low;
	}

}
