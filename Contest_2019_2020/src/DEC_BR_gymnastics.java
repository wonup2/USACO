import java.util.*;
import java.io.*;
public class DEC_BR_gymnastics {
	
	static Scanner in;
	static PrintWriter out;
	static int k, n, a[][];
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("gymnastics.in"));
		out = new PrintWriter(new File("gymnastics.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		k=in.nextInt();
		n=in.nextInt();
		
		a=new int[k][n];
		for(int i=0; i<k; i++) 
			for(int j=1; j<=n; j++) 
				a[i][in.nextInt()-1]=j;
			
		//System.out.println(Arrays.deepToString(a));
		
	}
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {  
			for(int j=i+1; j<n; j++) {	
				
				int win = 0;
				
				for(int m=0; m<k; m++) if(a[m][i]<a[m][j]) win++;					
					
				if(win==k || win==0) ans++;	
			}
		}		
		out.println(ans);
	}
}
