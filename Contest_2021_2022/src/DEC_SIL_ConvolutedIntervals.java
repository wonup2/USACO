import java.util.*;
import java.io.*;

public class DEC_SIL_ConvolutedIntervals {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m;
	static pair a[];
	static long k[];	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new File("out.out"));
		init();
		solve();
		out.close();
	}
	
	public static void init() throws NumberFormatException, IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new pair[n];
		k = new long[m*2+2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
	
	public static void solve() {

		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int s = a[i].a + a[j].a;
				int e = a[i].b + a[j].b;
				System.out.println(s + " " + e);
				if(s<=e) {					
					k[s]++;
					k[e+1]--;
					if(i!=j) {
						k[s]++;
						k[e+1]--;
					}
				}
				System.out.println(Arrays.toString(k));

			}
		}
		
		
		//System.out.println(Arrays.toString(k));
		
		for(int i=1; i<k.length; i++)
			k[i] += k[i-1];
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k.length-1; i++)
			sb.append(k[i]).append("\n");
		
		out.print(sb.toString());
	}
	
	
	
	static class pair{
		int a, b;
		pair(int c, int d){
			a = c; 
			b = d;
		}
		public String toString() {
			return a+" "+b;
		}
	}
}

/*
0
0
1
3
4
4
4
3
3
1
1
*/
