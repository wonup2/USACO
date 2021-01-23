import java.util.*;
import java.io.*;

public class JAN_BR_uddered {

	static Scanner in;
	static String a, b;
	static int ans, n, x, y;

	
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
		ans = 1;
	}
	
	static void solve() {
		
		x = a.indexOf(b.charAt(0));
		
		for(int i=1; i<n; i++) {
			y = a.indexOf(b.charAt(i));
			if(x >= y) ans++;
			x = y;
		}		
		
		System.out.println(ans);
	}	
}
