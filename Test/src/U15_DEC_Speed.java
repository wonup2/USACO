import java.util.*;
import java.io.*;


public class U15_DEC_Speed {

	static Scanner in;
	static PrintWriter out;
	static String file = "test";
	static ArrayList<Integer> a, b;
	static int n, m;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			
			int num = in.nextInt();
			int speed = in.nextInt();
			
			for(int j=0; j<num; j++) a.add(speed);
		}
		
		for(int i=0; i<m; i++) {
			
			int num = in.nextInt();
			int speed = in.nextInt();
			
			for(int j=0; j<num; j++) b.add(speed);
		}
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<100; i++)
			ans = Math.max(b.get(i)-a.get(i), ans);
		
		out.println(ans);
	}
}
