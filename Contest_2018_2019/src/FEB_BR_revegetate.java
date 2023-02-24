import java.util.*;
import java.io.*;
public class FEB_BR_revegetate {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m;
	static ArrayList<Integer> a[];
	static ArrayList<String> b[];

	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(System.in);

		init();
		solve();		
	}
	
	static void init() throws IOException {

		n = in.nextInt();
		m = in.nextInt();
		
		a = new ArrayList[n];
		b = new ArrayList[n];
	
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<Integer>();
			b[i] = new ArrayList<String>();
			for(int j=1;j<=4; j++)	b[i].add(j+"");
		}
				
		for(int i=0; i<m; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);
		}
	}
	
	static void solve() throws IOException {
		
		String ans = "";
		
		for(int i=0; i<n; i++) {
			
			String seed = b[i].get(0);
			ans += seed;
			
			for(int j:a[i]) b[j].remove(seed);						
		}
		
		System.out.println(ans);
	}
}
