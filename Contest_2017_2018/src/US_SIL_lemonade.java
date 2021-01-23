import java.util.*;
import java.io.*;

public class US_SIL_lemonade {
	
	static BufferedReader in;
	static PrintWriter out;
	static int a[], n;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("lemonade.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));	
		init();
		solve();
		in.close();
		out.close();
	}		
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
				
		Arrays.sort(a);
	}
	
	static void solve() {
		
		int ans=0;
		for(int i=n-1; i>=0; i--){
			if(a[i]<ans) break;
			ans++;
		}
		
		out.println(ans);
	}
}
