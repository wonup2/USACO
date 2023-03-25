import java.io.*;
import java.util.*;

public class US_BR_factory {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;
    static String filename = "factory";

	static int n, a[], b[];
	
	static void init() throws NumberFormatException, IOException {
		n = in.nextInt();
		a = new int[n+1];
		b = new int[n+1];
		for(int i=1; i<n; i++) {
			a[in.nextInt()]++;
			b[in.nextInt()]++;
		}
		
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		int ans = -1;
		boolean ok = false;
		int cnt=0;
		
		for(int i = 1; i<=n; i++) {
			if(a[i]==0 && b[i]>=1) {
				if(!ok) ans=i; 
				ok = true; 
				cnt++;
			}			
		}
		
		out.println(cnt==1? ans : -1);
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(filename+".in"));
		out = new PrintWriter(new PrintWriter(filename+".out"));
		init();
		solve();	
		in.close();
		out.close();	
	}
}
