import java.util.Arrays;
import java.util.Scanner;

public class bs {

	static int low, high, mid, ans, n, m, a[];
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++)a[i] = in.nextInt();
		
		Arrays.sort(a);
	}
	static void solve() {
		
		low = 0;
		high = a[n-1];
		
		while(low <= high) {
			
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
	}
	
	static boolean check(int mid) {
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(a[i] >= mid) sum+=a[i]-mid;
		}
		
		return sum >= m;
	}
}
