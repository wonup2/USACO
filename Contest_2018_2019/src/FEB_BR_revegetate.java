import java.io.*;
import java.util.*;

public class FEB_BR_revegetate {

	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static String ans;
	static ArrayList<Integer>a[];
	static ArrayList<String>f[];
	
	
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
=======
		
		in = new Scanner(System.in);

		init();
		solve();		
	}
	
	static void init() throws IOException {
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27

		in = new Scanner(new FileReader("revegetate.in"));
		out = new PrintWriter(new FileWriter("revegetate.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
	static void init() throws NumberFormatException, IOException {
		n = in.nextInt();
		m = in.nextInt();
		
		f = new ArrayList[n];
		a = new ArrayList[n];

		for(int i=0; i<n; i++) {
			f[i] = new ArrayList<String>();
			f[i].add("1");f[i].add("2");f[i].add("3");f[i].add("4");
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int min = Math.min(x, y);
			int max = Math.max(x, y);
			a[min].add(max);
		}		
	}
	
	static void solve() {
		
		ans = "";
		
		for(int i=0; i<n; i++) {
			String cur = f[i].get(0);
			ans+=cur;
			
			for(int k: a[i]) f[k].remove(cur);			
		}
<<<<<<< HEAD
		
		out.println(ans);
=======
	}
	
	static void solve() throws IOException {
		
		String ans = "";
		
		for(int i=0; i<n; i++) {
			
			String seed = b[i].get(0);
			ans += seed;
			
			for(int j:a[i]) b[j].remove(seed);						
		}
		
		System.out.println(ans);
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
	}
}
