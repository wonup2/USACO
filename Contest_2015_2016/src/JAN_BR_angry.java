import java.io.*;
import java.util.*;
public class JAN_BR_angry {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[];

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("angry.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		n = in.nextInt();
		a = new int[n];
		for(int i = 0; i < n; i++) a[i] = in.nextInt();
				
		Arrays.sort(a);		
	}
	
	static void solve() {
		
		int ans = 1;
		
		for(int i = 0; i < n; i++) {
			
			int left = getIdx(i, true);			
			int right = getIdx(i, false);			
			int explosion = right - left + 1;
			
			if(explosion > ans) ans = explosion;			
		}
		
		out.println(ans);
	}
	

	public static int getIdx(int idx, boolean left) {
		
		int r = 1;
		int d = left? -1:1;			

		while(idx > 0 && idx < a.length-1) {	

			int next = idx;
			while(true) {
				if(next+d<0||next+d>=n||Math.abs(a[next+d]-a[idx])>r) break;
				next += d;
			}
			
			if(next == idx)	break;	
			
			idx = next;
			r++;
		}
		return idx;
	}
	
}