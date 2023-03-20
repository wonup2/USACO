import java.util.*;
import java.io.*;


public class convention {

	static Scanner in;
	static PrintWriter out;
	static String file = "test";
	
	static int n, m, c, a[];
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		c = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		Arrays.sort(a); //System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int ans = 0;
		int low = 0;
		int high = a[n-1]-a[0];
		//System.out.println(high);
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		
		out.println(ans);
	}
	
	static boolean check(int wt) {
		int start = a[0];
		int bus = 1;
		int cow = 1;
		
		for(int i=1; i<n; i++) {
			
			if(a[i]-start > wt || cow==c) {
				start = a[i];
				bus++;
				cow = 1;
			}
			else cow++;
			
		}
		
		return bus <= m;
	}
}
















