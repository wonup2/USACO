import java.util.*;
import java.io.*;
public class DEC_BR_gymnastics {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int k, n, a[][];
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("gymnastics.in"));
		out = new PrintWriter(new PrintWriter("gymnastics.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		k=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		a=new int[k][n+1];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1; j<=n; j++) {
				int t=Integer.parseInt(st.nextToken());
				a[i][t]=j;
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
	static void solve() {
		int ans = 0;
		for(int i=1; i<n; i++) {  
			for(int j=i+1; j<=n; j++) {	
				int win = 0;
				for(int m=0; m<k; m++) {
					if(a[m][i]<a[m][j]) win++;					
				}			
				if(win==k || win==0) ans++;	
			}
		}		
		out.println(ans);
	}
}
