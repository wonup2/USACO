import java.util.*;
import java.io.*;

public class USACO_template {

	static BufferedReader in;
	static PrintWriter out;
	static int N, M, P, A;
	static pair[] a;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("xxx.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("xxx.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new pair[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			P = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(a));
	}
	static void solve() {
		
	}	
}
