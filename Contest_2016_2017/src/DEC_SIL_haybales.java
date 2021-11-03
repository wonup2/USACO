import java.util.*;
import java.io.*;
public class DEC_SIL_haybales {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, q, a[];
	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("haybales.in"));
		out = new PrintWriter(new PrintWriter("haybales.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(in.readLine());  //4 6
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		st = new StringTokenizer(in.readLine());  //3 2 7 5

		for(int i=0; i<n; i++) 
			a[i] = Integer.parseInt(st.nextToken());	
		
		Arrays.sort(a);
	}
	
	public static void solve() throws IOException {

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int ans = count(s,e);
			sb.append(ans).append("\n");
		}
		out.print(sb.toString());
	}
	
		
	public static int count(int s, int e) {
		s = Arrays.binarySearch(a, s);
		e = Arrays.binarySearch(a, e);

		if(s < 0) s = s*(-1) - 1;

		if(e < 0) e = e*(-1) - 2;

		return e - s + 1;
	}
	
	
	/*
	public static int lower(int n) {
		if(n<a[1]) return 0;
		int low = 1;
	    int high = a.length-1;
	    while (low <= high) {
	        int mid = (low + high) / 2;
	        if(n==a[mid]) return mid;
	        else if (n < a[mid]) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return high;
	}
	*/

}
