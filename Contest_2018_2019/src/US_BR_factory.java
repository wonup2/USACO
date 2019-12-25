import java.io.*;
import java.util.*;

public class US_BR_factory {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, a[], b[];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("factory.in"));
		out = new PrintWriter(new FileWriter("factory.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
	static void init() throws NumberFormatException, IOException {
		n=Integer.parseInt(in.readLine());
		a = new int[n+1];
		b = new int[n+1];
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[Integer.parseInt(st.nextToken())]++;
			b[Integer.parseInt(st.nextToken())]++;
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		int ans = -1;
		boolean ok = false;
		int cnt=0;
		for(int i = 1; i<=n; i++) {
			if(a[i]==0 && b[i]>=1) {
				if(!ok) ans=i; 
				ok = true; 
				cnt++;
			}			
		}
		out.println(cnt==1?ans:-1);
	}
}
