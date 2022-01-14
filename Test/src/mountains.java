import java.util.*;
import java.io.*;

public class mountains {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m[];
	static long ans;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("mountains.in"));
		out = new PrintWriter(new File("mountains.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		m = new int[n*2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			m[i*2] = Integer.parseInt(st.nextToken());
			m[i*2+1] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		//System.out.println(Arrays.toString(m));
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			int cur = i*2;
			int see = 1;
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				int next = j*2;
				
				int dx = Math.abs(m[next]-m[cur]);
				int dy = m[next+1]-m[cur+1];
				
				if(dx<=dy) {
					see=0;
					break;
				}
			}
			ans+=see;
		}
		
		out.println(ans);
	}	
}
