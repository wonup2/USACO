import java.util.*;
import java.io.*;

public class JAN_BR_uddered {

	static Scanner in;
	static String a, b;
	static int c[], ans, n;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		a = in.next().toLowerCase();
		b = in.next().toLowerCase();
		n = b.length();
		c = new int[n];
		ans = 1;
	}
	
	static void solve() {
		
		c[0] = a.indexOf(b.charAt(0));
		for(int i=1; i<n; i++) {
			c[i] = a.indexOf(b.charAt(i));
			if(c[i-1] >= c[i]) ans++;
		}
		
		
		//System.out.println(Arrays.toString(c));
		System.out.println(ans);
	}	
}
