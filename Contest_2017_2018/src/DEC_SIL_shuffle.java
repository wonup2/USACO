import java.util.*;
import java.io.*;

public class DEC_SIL_shuffle {

	static BufferedReader in;
	static PrintWriter out;
	static int n, a[], b[], ans;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("shuffle.in"));
		out = new PrintWriter(new FileWriter("shuffle.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new int[n];
		b = new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken())-1;
			b[a[i]]++;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		ans = n;
		for(int i=0; i<n; i++) {
			if(b[i]==0) {
				q.add(i);		
				ans--;
			}
		}
		System.out.println(q);
		System.out.println(ans);

		while(!q.isEmpty()) {
			int t = q.poll();
			if(--b[a[t]]==0) {
				q.add(a[t]);
				ans--;				
			}
		}
		out.println(ans);
	}
}
