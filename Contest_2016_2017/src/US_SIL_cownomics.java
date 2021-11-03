import java.util.*;
import java.io.*;

public class US_SIL_cownomics {

	static Scanner in;
	static PrintWriter out;
	static String[] spotty, plain;
	static int n, m, ans;
	static HashSet<String> set;
	
	public static void main(String[] args) throws Exception {

		in = new Scanner(new File("cownomics.in"));
		out = new PrintWriter(new FileWriter("cownomics.out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		ans = 0;

		spotty = new String[n];
		for (int i=0; i<n; i++) spotty[i] = in.next();
		
		plain = new String[n];
		for (int i=0; i<n; i++) plain[i] = in.next();

	}
	
	static void solve() {
		
		for (int i=0; i<m; i++)
			for (int j=i+1; j<m; j++)
				for (int k=j+1; k<m; k++)
					if (counts(i, j, k)) ans++;

		out.println(ans);
	}

	
	public static boolean counts(int x, int y, int z) {
		
		set = new HashSet<String>();

		for (int i=0; i<n; i++)
			set.add(""+spotty[i].charAt(x) + spotty[i].charAt(y) + spotty[i].charAt(z));
		
		for(String s: set) {				
			for (int i=0; i<n; i++) {
				String p = ""+ plain[i].charAt(x) + plain[i].charAt(y) + plain[i].charAt(z);
				if(s.equals(p)) return false;		
			}
		}
		
		return true;
	}	
}