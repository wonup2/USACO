import java.util.*;
import java.io.*;

public class JAN_SIL_soulmates {

	static BufferedReader in;
	static StringTokenizer st;
	static long n, a, b, ans;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		in.close();
	}

	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			ans = solve(a, b);
			System.out.println(ans);
		}		
	}
	
	static long solve(long a, long b) {
		if(a==b) return 0;
		if(a>b) {
			long odd = a%2;
			return 1+odd+solve((a+odd)/2, b); 
		}
		else {
			long odd = b%2;
			return Math.min(b-a, 1+odd+solve(a, b/2));
		}
	}	
}
