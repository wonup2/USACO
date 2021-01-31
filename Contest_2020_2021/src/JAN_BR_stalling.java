import java.util.*;
import java.io.*;

public class JAN_BR_stalling {

	static Scanner in;
	static int a[], b[], c[], n;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[n];
		
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		for(int i=0; i<n; i++) b[i] = in.nextInt();		
	}
	
	static void solve() {
		
		Arrays.sort(a);
		
		for(int i=0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(a[i]<=b[j]) c[i]++;
			}
		}
				
		long ans = 1;
		for(int i=0; i<n; i--) ans *= c[i]-i;
				
		System.out.println(ans);
	}	
}
