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
		
		Arrays.sort(b);

		long ans = 1l;
		
		for(int i=0; i<n; i++) {
			long fit = 0;
			for(int j = 0; j<n; j++) {
				if(b[i]>=a[j]) fit++;
			}
			fit	-=i;
			ans *= fit;
		}
				
		System.out.println(ans);
	}	
}
