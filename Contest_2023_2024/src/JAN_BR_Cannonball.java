import java.util.*;
import java.io.*;


public class JAN_BR_Cannonball {

	static BufferedReader in;
	static StringTokenizer st;
	static int N, S, q[], v[], power, d, ans ;
	static boolean b[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
		
		in.close();
	}

	static void init() throws IOException {
		
		st=new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken())-1;
		
		q = new int[N];
		v = new int[N];
		b = new boolean[N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(in.readLine());
			q[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}		
		power = 1;
		d = 1;
	}
	
	static void solve() {
		int i=0;
		while(S >= 0 && S < N && i<5000000) {

			if(q[S] == 0) {
				power += v[S];
				d*=-1;
			}
			
			else {
				if(b[S]==false && v[S]<=power) {
					ans++; 
					b[S] = true;
				}
			}
			S+=d*power; 
			i++;
		}
		
		System.out.println(ans);
	}
}
