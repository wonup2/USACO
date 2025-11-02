import java.util.*;
import java.io.*;

public class FEB_SIL_maxcross {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer tok = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());

		int[] a = new int[n];
		Arrays.fill(a, 1);  	
		
		// Set the bad ones.
		for (int i=0; i<b; i++) a[Integer.parseInt(in.readLine())-1] = 0; 
		for (int i=1; i<n; i++) a[i] += a[i-1];  		
				
		int cur = k-1;
		int fix = a[cur]; 
		cur++;
		for (int i=0; i<n && cur<n; i++) {
			fix = Math.min(k-(a[cur]-a[i]), fix);
			cur++;		
		}
		
		PrintWriter out = new PrintWriter(new FileWriter("maxcross.out"));
		out.println(fix);
		out.close();
		in.close();
	}
}