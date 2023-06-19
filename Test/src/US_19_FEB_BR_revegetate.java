import java.util.*;
import java.io.*;


public class US_19_FEB_BR_revegetate {
	static Scanner in;
	static PrintWriter out;
	
	static int n, m;
	static String p[], ans;
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("revegetate.in"));
		out = new PrintWriter(new File("revegetate.out"));
		
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();

		p = new String[n];
		for(int i=0; i<n; i++) p[i] = "1234";
		
		a = new ArrayList[n];
		for(int i=0; i<n; i++) a[i] = new ArrayList<Integer>();
		
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			
			if(x<y) a[x].add(y);
			else a[y].add(x);
		}

		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(a));
	}

	static void solve() {
		
		ans = "";
		
		for(int i=0; i<n; i++) {
			String cur = p[i].substring(0,1);
			ans+= cur;
			
			for(int num: a[i]) {
				p[num] = p[num].replace(cur, "");
			}
		}
		
		out.println(ans);
	}
}
