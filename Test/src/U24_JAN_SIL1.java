import java.util.*;
import java.io.*;


public class U24_JAN_SIL1 {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, q, c, a[], b[];
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
			if(a[i]==0) {
				a[i]=1;
				z[i]=true;
			}
		}
		
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(in.readLine());
			b[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(z));
//		System.out.println(Arrays.toString(b));

	}
	
/*
10 4 10
1 2 0 2 1 5 8 6 0 3
4 7
1 2
5 7
3 7

*/
	static void solve() {
		
		//b
		for(int i=1; i<=n; i++) {
			if(b[i]==0) continue;
			
			for(int j=i; j<b[i]; j++) {
				if(b[j]!=0 && b[j]!=b[i]) {
					System.out.println(-1);
					return;
				}
				b[j] = b[i];
			}
			
			i = b[i];
		}
		
		int lmax = 0, rmax = 0;
		for(int i=1; i<=n; i++) {
			
			lmax = Math.max(lmax, a[i]);
			rmax = Math.max(rmax, a[i]);

			if(b[i]==0) continue;

			for(int j=i; j<b[i]; j++) rmax = Math.max(rmax, a[j]);
			
			if(lmax < rmax) {
				boolean zero = false;
				for(int j=i; j>0; j--) {
					if(!z[j]) continue;
					if(b[j]!=0&&b[j]<b[i]) {
						System.out.println(-1);
						return;
					}
					zero = true;
					a[j] = rmax;
					break;
				}
				
				if(!zero) {
					System.out.println(-1);
					return;
				}
				
				lmax = rmax;				
			}
			
			if(z[b[i]]) a[b[i]] = lmax+1;
			
			if(a[b[i]] <= lmax) {
				System.out.println(-1);
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(a[i] > c) {
				System.out.println(-1);
				return;
			}
			
			sb.append(a[i]);
			if(i==n) sb.append("\n");
			else sb.append(" ");
		}
		
		System.out.print(sb.toString());
	}
}
