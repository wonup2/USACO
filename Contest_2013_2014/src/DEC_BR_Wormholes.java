import java.io.*;
import java.util.*;

public class DEC_BR_Wormholes {

	static Scanner in;
	static PrintWriter out;
	static int n, x[], y[], p[], r[];
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("wormhole.in"));
		out = new PrintWriter(new File("wormhole.out"));
		init();
		out.println(solve());
		in.close();
		out.close();
	}
	
	static void init(){
		n = in.nextInt();
		x = new int[n+1];
		y = new int[n+1];
		p = new int[n+1];
		r = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		System.out.println("x: "+Arrays.toString(x));
		System.out.println("y: "+Arrays.toString(y));
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(x[i]<x[j] && y[i]==y[j]) {
					if(r[i]==0 || x[j]-x[i] < x[r[i]]-x[i])
						r[i]=j;
				}
			}			
		}
		
		System.out.println("r: "+Arrays.toString(r));

	}
	
	static int solve() {
		int i=0, total=0;
		for(i=1; i<=n; i++) {
			if(p[i]==0) break;
		}
		if(i>n) {
			System.out.println(Arrays.toString(p));
			if(hasCycle()) return 1;
			else return 0;
		}

		for(int j=i+1; j<=n; j++) {
			if(p[j]==0) {
				p[j]=i;
				p[i]=j;		
				total+=solve(); 
				System.out.println(total);

				p[i]=p[j]=0;
			}
		}
		return total;
	}
	
	static boolean hasCycle() {
		
		for(int i=1; i<=n; i++) {
			int pos = i;
			for(int j=0; j<n; j++) {
				pos = r[p[pos]];
			}
			if(pos!=0) return true;
		}
		
		return false;
	}
}
