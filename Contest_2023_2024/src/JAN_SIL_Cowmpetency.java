import java.util.*;
import java.io.*;


public class JAN_SIL_Cowmpetency {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, q, c, a[], b[], a1, h;
	static boolean z[];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}		
		in.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[n+1];
		b = new int[n+1];
		z = new boolean[n+1];
		
		st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) { 
			a[i] = Integer.parseInt(st.nextToken());
			if (a[i]!=0) z[i] = true;
			else a[i] = 1;
		}
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			a1 = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			b[a1] = h;				
		}
	}
	
	static void solve() throws IOException {
		
		for(int i=1; i<=n; i++) {
	        for (int j=i; j<b[i]; j++) {
	        	if (b[j] != 0 && b[j] != b[i]) {
	        		System.out.println(-1);
	        		return;
	        	}
	        	b[j] = b[i];        		
	        }
		}
				
		for(int i=1; i<=n; i++) {
			if(b[i] == 0) continue;
			
			int mxLeft = a[0];			
			for(int j=1; j<=i; j++)
				mxLeft = Math.max(a[j], mxLeft);
			
			int maxRight = a[0];
			for(int j=1; j<b[i]; j++)	
				maxRight = Math.max(a[j], maxRight);
			
			if(mxLeft < maxRight) {
				boolean found = false;

				for(int j=i; j>0; j--) {
					
					if(z[j]) continue;

					if(b[j] !=0 && b[j] < b[i]) { 
						System.out.println(-1);
						return;
					}
					
					a[j] = maxRight;
					found = true;
					break;
				}
				if(!found) {
					System.out.println(-1);
					return;
				}
				
				mxLeft = maxRight;
			}
			
			if(!z[b[i]]) {
				a[b[i]] = mxLeft + 1;
			}
						
			if(a[b[i]] <= mxLeft) {

				System.out.println(-1);
				return;
			}
		}		
		
		//check and print
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(a[i] > c) {
				System.out.println(-1);
				return;
			}
			
			if(i==n)sb.append(a[i]).append("\n");
			else sb.append(a[i]).append(" ");
		}
		
		System.out.print(sb.toString());
	}
}
