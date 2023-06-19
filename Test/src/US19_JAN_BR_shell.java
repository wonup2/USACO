import java.util.*;
import java.io.*;

public class US19_JAN_BR_shell {

	static Scanner in;
	static PrintWriter out;
	static int n, a[], b[], g[], ans;
	static boolean p[];
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("shell.in"));
		out = new PrintWriter(new File("shell.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		b = new int[n];
		g = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt()-1;
			b[i] = in.nextInt()-1;
			g[i] = in.nextInt()-1;
		}
		
		p = new boolean[3];
		
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(g));

	}
	
	static void solve() {
		
		for(int i=0; i<3; i++) {
			Arrays.fill(p, false);
			p[i] = true;
			ans = Math.max(swap(), ans);
		}
	
		out.println(ans);
		
	}
	
	static int swap() {
		
		int score = 0;
		for(int i=0; i<n; i++) {
			
			int left = a[i];
			int right = b[i];
			int bet = g[i];
			
			boolean temp = p[left];
			p[left] = p[right];
			p[right] = temp;
			
			if(p[bet]) score++;			
		}
		
		return score;
	}
}
