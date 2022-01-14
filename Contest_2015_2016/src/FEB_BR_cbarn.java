import java.util.*;
import java.io.*;

public class FEB_BR_cbarn{

	static Scanner in;
	static PrintWriter out;
	static int n, ans;
	static Queue<Integer> a;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("cbarn.in"));
		out = new PrintWriter(new File("cbarn.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		
		a = new LinkedList<Integer>();

		for(int i=0; i<n; i++) a.add(in.nextInt());

		ans = 0;		
	}
	
	static void solve() {

		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			ans = 0;
			for(int j=0; j<n; j++) {
				ans += a.peek()*j;
				a.add(a.poll());				
			}		
			a.add(a.poll());
			min = Math.min(ans, min);
		}
		out.println(min);
	}	
}
