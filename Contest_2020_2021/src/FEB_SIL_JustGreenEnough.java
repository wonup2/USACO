import java.util.*;
import java.io.*;

public class FEB_SIL_JustGreenEnough {
	
	static BufferedReader in;
	static int n;
	static long[][] a, b;
  
	public static void main(String[] args) throws IOException {  

		in = new BufferedReader(new InputStreamReader(System.in));
		init();

		in.close();
	}
	
	public static void init() throws NumberFormatException, IOException {
		
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		a = new long[n+1][n+1];
		b = new long[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j<= n; j++) {
				int inp = Integer.parseInt(st.nextToken());
				if (inp > 100) a[i][j] = 0;
				else if (inp < 100) a[i][j] = 3;
				else a[i][j] = 100000;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				b[i][j] = a[i][j] + b[i-1][j] + b[i][j-1] - b[i-1][j-1];
			}
		}
		
		long counter =0;
	    for (int x1 = 1; x1 <= n; x1++) {
	      for (int y1 = 1; y1 <= n; y1++) {
	        for (int x2 = x1; x2 <= n; x2++) {
	          for (int y2 = y1; y2 <= n; y2++) {
	            long sum = b[x2][y2] - b[x1-1][y2] - b[x2][y1-1] + b[x1-1][y1-1];
	            if (sum % 100000 == 0 && sum!=0) counter++;
	          }
	        }
	      }
	    }
	    System.out.println(counter);
	  }
}