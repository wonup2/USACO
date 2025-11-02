import java.util.*;
import java.io.*;

public class DEC_BR_shuffle {
	
	static int n, shuffle[], id[], ans[];
	static Scanner in;
	static PrintWriter out;
	

	static void init() {
		
		n = in.nextInt();
		
		shuffle = new int[n];
		for(int i=0; i<n; i++) shuffle[in.nextInt()-1]=i;
		
		id = new int[n];
		for(int i=0; i<n; i++) id[i] = in.nextInt();
	}
	
	static void solve() {
		
		ans = new int[n];
		
		for(int i=0; i<n; i++) ans[shuffle[shuffle[shuffle[i]]]] = id[i];
		
		for(int i=0; i<n; i++) out.println(ans[i]);		
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("shuffle.in"));
		out = new PrintWriter(new File("shuffle.out"));
		init();
		solve();
		in.close();
		out.close();
	}
}
