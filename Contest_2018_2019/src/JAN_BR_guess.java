import java.util.*;
import java.io.*;

public class JAN_BR_guess {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static HashSet<String>[] a;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("guess.in"));
		out = new PrintWriter(new File("guess.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	@SuppressWarnings("unchecked")
	static void init() {
		n=in.nextInt();
		a=new HashSet[n];
		
		for(int i=0; i<n; i++) {
			a[i]=new HashSet<String>();
			in.next();
			int m = in.nextInt();
			while(m-->0) a[i].add(in.next());			
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int max=0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				
				int cnt=1;
				for(String s:a[i]) if(a[j].contains(s)) cnt++;
				
				max=Math.max(max, cnt);		
			}
		}	
		out.println(max);
	}
}
