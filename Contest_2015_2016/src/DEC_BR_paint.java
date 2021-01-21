import java.util.*;
import java.io.*;

public class DEC_BR_paint {

	static Scanner in;
	static PrintWriter out;
	static int a, b, c, d, f[];

	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("paint.in"));
		out = new PrintWriter(new FileWriter("paint.out"));
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
		f = new int[101];
	}
	static void solve() {
		for(int i=a; i<b; i++) f[i]=1;
		for(int i=c; i<d; i++) f[i]=1;
		
		int cnt = 0;
		for(int i=0; i<101; i++) if(f[i]==1) cnt++;
		
		out.println(cnt);
	}	
}