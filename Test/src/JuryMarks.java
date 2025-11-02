import java.io.*;
import java.util.*;

public class JuryMarks {
	static BufferedReader in;
	static StringTokenizer st;
	static int k, n, a[], b[];
	
	static void init() throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		a = new int[k + 1];
		b = new int[n];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= k; i++) 
			a[i] = Integer.parseInt(st.nextToken()) + a[i - 1];		
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) 
			b[i] = Integer.parseInt(st.nextToken()); 
	}
	
	static void solve() {
		
		Set<Integer> set = new TreeSet<>();
		for (int i = 1; i <= k; i++) 
			set.add(b[0] - a[i]);
		
		int ans = 0;
		for (int s : set) {
			Set<Integer> p = new TreeSet<>();
			for (int i = 1; i <= k; i++) p.add(s + a[i]); 

			boolean valid = true;
			for (int v : b) valid &= p.contains(v); 

			ans += valid ? 1 : 0;
		}
		System.out.println(ans);
	}
		
	public static void main(String[] args) throws IOException {
		
		init();
		solve();
		
		in.close();
	}
}