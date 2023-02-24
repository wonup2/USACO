import java.io.*;
import java.util.*;
public class FEB_BR_traffic {
	static BufferedReader in;
	static PrintWriter out;
	static int N, a, b, A[], B[];
	static String T[];
	
	public static void main(String[] args) throws IOException {

		init();
		solve();
		
		in.close();
		out.close();		
	}

	static void init() throws IOException {
		in = new BufferedReader(new FileReader("traffic.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
		N = Integer.parseInt(in.readLine());
		T=new String[N];
		A=new int[N];
		B=new int[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			T[i] = st.nextToken();
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}			
	}

	private static void solve() {
		
		a = -999999999; b = 999999999;
		
		for(int i=N-1; i>=0; i--) {
			if (T[i].equals("none")) { 
				a = Math.max(a, A[i]); 
				b = Math.min(b, B[i]);
			}
			else if (T[i].equals("off")) { 
				a += A[i]; 
				b += B[i];
			}
			else if (T[i].equals("on")) { 
				a -= B[i]; 
				b -= A[i]; 
				a = Math.max(0,a);
			}
		}
		out.println(a+" "+b);
		
		
		a = -999999999; b = 999999999;
		
		for(int i=0; i<N; i++) {
			if (T[i].equals("none")) { 
				a = Math.max(a, A[i]); 
				b = Math.min(b, B[i]); 
			}
			else if (T[i].equals("on")) { 
				a += A[i]; 
				b += B[i]; 
			}
			else if (T[i].equals("off")) { 
				a -= B[i]; 
				b -= A[i]; 
				a = Math.max(0,a); 
			}
		}
		out.println(a+" "+b);
	}
}
