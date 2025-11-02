import java.io.*;
import java.util.*;
public class US_BR_diamonds {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, k, a[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("diamond.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		a = new int[n];
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(a);
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			int amt = 0;
			for(int j = i; j < n; j++)
				if(a[j]-a[i] <=k) amt++;	
			
			ans = Math.max(amt, ans);			
		}
			
		out.println(ans);
	}
}