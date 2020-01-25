import java.util.*;
import java.io.*;

public class JAN_BR_word {

	static BufferedReader in;
	static PrintWriter out;
	static int n, k;
	static String a[];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("word.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		a=in.readLine().split(" ");		
	}
	static void solve() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(a[0]);
		int t = a[0].length();
		for(int i=1; i<n; i++) {
			t+=a[i].length();		
			if(t<=k) sb.append(" ");			
			else {
				sb.append("\n");
				t=a[i].length();
			}
			sb.append(a[i]);
		}
		out.println(sb.toString());
	}
}
