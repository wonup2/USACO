import java.util.*;
import java.io.*;

public class JAN_BR_sleepy {

	static Scanner in;
	static PrintWriter out;
	static int a[], n;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("sleepy.in"));
		out = new PrintWriter(new File("sleepy.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		n = in.nextInt();
		a=new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
	}
	static void solve() {
		int ans = 0;
		for(int i=n-1; i>=1; i--) {
			if(a[i-1] > a[i]) { ans=i; break; }
		}
		
		out.println(ans);
	}
}