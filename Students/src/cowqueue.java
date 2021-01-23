import java.util.*;
import java.io.*;

public class cowqueue {
	
	static Scanner in;
	static int n, ans;
	static pair a[];
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		
		a = new pair[n];
		
		for(int i=0; i<n; i++) {
			
			a[i] = new pair(in.nextInt(), in.nextInt());
			
		}
		
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));		
	}
	
	static void solve() {
		
		ans = a[0].a + a[0].i;
		
		for(int i=1; i<n; i++) {
			
			if(ans < a[i].a) ans = a[i].a + a[i].i;
			else ans += a[i].i;			
			
		}
		
		System.out.println(ans);
	}
	
	static class pair implements Comparable<pair>{
		//data fields
		int a;
		int i;
		
		//constructor
		pair(int x, int y){
			a = x;
			i = y;
		}
				
		@Override
		public int compareTo(cowqueue.pair o) {
			if(this.a < o.a) return -1;
			else return 1;
		}
		
		public String toString() {
			return a+"-"+i;
		}		
	}	
}

/*
3
2 1
8 3
5 7
*/