import java.util.*;
import java.io.*;

public class revegetate {

	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static String ans;
	static ArrayList<String> f[];
	static ArrayList<Integer> a[];

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("revegetate.in"));
		out = new PrintWriter(new File("revegetate.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new ArrayList[n];
		f = new ArrayList[n];
		
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<Integer>();
			f[i] = new ArrayList<String>();
		}
		
		for(int i = 0; i<n; i++) {
			f[i].add("1"); 
			f[i].add("2");
			f[i].add("3"); 
			f[i].add("4");
		}
		
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);
		}
		
		System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(f));

	}
	
	static void solve() {
		String ans = "";
		for(int i=0; i<n; i++) {
			String seed = f[i].get(0);	
			ans+=seed;
			for(int num: a[i]) {
				f[num].remove(seed);
			}
			//System.out.println(seed+" "+Arrays.toString(f));
		}			
		System.out.println(ans);
	}	
}
