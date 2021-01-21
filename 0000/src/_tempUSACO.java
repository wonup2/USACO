import java.util.*;
import java.io.*;

public class _tempUSACO {

	static Scanner in;
	static PrintWriter out;
	static int a, b, c, d, ans;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("xxx.in"));
		out = new PrintWriter(new File("xxx.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		
		System.out.printf("%d %d %d %d", a, b, c, d);
		ans = 0;		
	}
	
	static void solve() {
		
		
		out.println(ans);
	}	
}
