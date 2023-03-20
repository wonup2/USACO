import java.util.*;
import java.io.*;

public class NumberMarbles {
	
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m, a[], ans, low, high;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));	
		init();
		solve();
		in.close();
	}
	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		a = new int[n];
        high = 0;
        low = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, a[i]);
			high += a[i];
		}
		ans = 0;
	}
	static void solve() {		

		low = 1;
		int mid=0;
		while(low <= high) {
			mid = (low+high)/2;
			
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		//-----------------------------------
        System.out.println(ans);
        
		int s = 0; 
		int t = 0;
		for(int i=0; i<n; i++) {
			s+=a[i];
			if(s>ans) {
				s = a[i];
				m--;
				System.out.print(t + " ");
				t = 0;
			}
			t++;
			if(n-i == m) break;
		}
        
		while(m-- > 0) {
			System.out.println(t+" ");
			t = 1;
		}
		
	}	
	
	static boolean check(int mid) {
		int group = 1;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(cnt + a[i] <= mid) cnt+=a[i];
			else {
				group ++;
				cnt = a[i];
			}
		}
		
		return group <= m;
	}
	
}
