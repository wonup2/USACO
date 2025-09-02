import java.util.*;
import java.io.*;

public class DEC_SIL_bcount {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, q, b1[], b2[], b3[];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("bcount.in"));
		out = new PrintWriter(new File("bcount.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		b1 = new int[n+1];
		b2 = new int[n+1];
		b3 = new int[n+1];
	}

	static void solve() throws IOException {
		
		for(int i=1; i<=n; i++) {
			b1[i] = b1[i-1];
			b2[i] = b2[i-1];
			b3[i] = b3[i-1];

			int num = Integer.parseInt(in.readLine());
			if(num==1) b1[i]++;
			else if(num==2) b2[i]++;
			else b3[i]++;
		}
		
		int a=0, b=0, c=0, s=0, e=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken())-1;
			e = Integer.parseInt(st.nextToken());
			a = b1[e] - b1[s];
			b = b2[e] - b2[s];
			c = b3[e] - b3[s];
			sb.append(a).append(" ").append(b).append(" ").append(c).append("\n");
		}
		out.print(sb.toString());
	}
}
