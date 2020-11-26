import java.util.*;
import java.io.*;

public class DEC_BR_shuffle {
	
	static int n, r[], id[], ans[];
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("shuffle.in"));
		out = new PrintWriter(new File("shuffle.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	static void init() {
		n = in.nextInt();
		r = new int[n];
		for(int i=0; i<n; i++) r[in.nextInt()-1]=i;
		id = new int[n];
		for(int i=0; i<n; i++) id[i] = in.nextInt();
	}
	
	static void solve() {
		ans = new int[n];
		
		for(int i=0; i<n; i++) ans[r[r[r[i]]]] = id[i];
		
		for(int i=0; i<n; i++) out.println(ans[i]);
		
	}
}
