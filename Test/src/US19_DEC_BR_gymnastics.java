import java.util.*;
import java.io.*;

public class US19_DEC_BR_gymnastics {

	static Scanner in;
	static PrintWriter out;
	static int n, k, a[][], ans;
	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("gymnastics.in"));
		out = new PrintWriter(new File("gymnastics.out"));
		
		init();
		solve();
		
		in.close();
		out.close();		
	}

	static void init() {
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n][k];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				
				a[i][in.nextInt()-1] = j;
				
			}
		}
		
		//System.out.println(Arrays.deepToString(a));
	}
	
	static void solve() {
		
		for(int i=0; i<k; i++) {
			for(int j=i+1; j<k; j++) {
				int leftwin=0;
				for(int r=0; r<n; r++) {					
					if(a[r][i] < a[r][j]) leftwin++;					
				}
				
				if(leftwin==n || leftwin==0) ans++;  //<--
			}
		}
		
		out.println(ans);
	}
}
