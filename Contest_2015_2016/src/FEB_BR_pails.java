import java.util.*;
import java.io.*;
public class FEB_BR_pails {
	static Scanner in;
	static PrintWriter out;
	static int X, Y, M;

	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("pails.in"));
		out = new PrintWriter(new File("pails.out"));
		
		init();
		solve();
		
		in.close();
		out.close();

	}
	static void init() {
		X=in.nextInt();
		Y=in.nextInt();
		M=in.nextInt();
		//System.out.println(X+" "+Y+" "+M);
	}
	static void solve() {
		int ans = 0;

		for(int i=0; i*X <= M; i++)
			for(int j=0; i*X + j*Y <= M; j++) 	
				ans = Math.max(ans, i*X + j*Y);	
							
		out.println(ans);
	}
}


