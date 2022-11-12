import java.util.*;
import java.io.*;

public class JAN_BR_stalling1 {

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
		
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		for(int i=0; i<n; i++) b[i] = in.nextInt();	
		
		Arrays.sort(a);
		Arrays.sort(b);

	}
	
	static void solve() {
		
		long ans = 1l;
		int j = 0;
		int num = 0;
		
		for(int i=0; i<n; i++) {			
		
			while(j < n && b[i]>=a[j]) {
				num++;
				j++;
			}
			
			ans *= num;
			num--;
		}
				
		System.out.println(ans);
	}	
}
