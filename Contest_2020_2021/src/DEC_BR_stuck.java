import java.util.*;

public class DEC_BR_stuck {
	static Scanner in;
	static int n, x[], y[], ind[];
	static char d[];
	static int cnt=0;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() {
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		d = new char[n];
		
		for(int i=0; i<n; i++) {
			d[i] = in.next().charAt(0);
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
	}
	
	static void solve() {
				
		for(int i=0; i<n; i++) {
			int ans = check(i);			
			if(ans==Integer.MAX_VALUE) System.out.println("Infinity");
			else System.out.println(ans);			
		}
	}
	
	static int check(int i) {
		int min = Integer.MAX_VALUE;
		if(d[i]=='E') {
			for(int j=0; j<n; j++) {
				if(i==j || d[j] == 'E'|| x[i] > x[j] || y[i] < y[j]) continue;				
				int dx = x[j]-x[i];
				int dy = y[i]-y[j];
			
				if(dx > dy && check(j) >= dy) min = Math.min(min, dx);
			}
		}
		
		else {
			for(int j=0; j<n; j++) {
				if(i==j || d[j] == 'N'|| x[i] < x[j] || y[i] > y[j]) continue;
				int dx = x[i]-x[j];
				int dy = y[j]-y[i];
				
				if(dx < dy && check(j) >= dx) min = Math.min(min, dy);			
			}
		}
		
		return min;
	}
}
