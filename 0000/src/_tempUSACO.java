import java.util.*;
import java.io.*;

public class _tempUSACO {

	static Scanner in;
	static int a[], b, c, d, ans;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		
		a = new int[b];

		System.out.printf("%d %d %d %d", b, c, d);
		System.out.println(Arrays.toString(a));
		ans = 0;		
	}
	
	static void solve() {
		
		
		System.out.println(ans);
	}	
}
