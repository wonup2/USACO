import java.util.*;
import java.io.*;

public class FEB_SIL_maxcross1 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer tok = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());

		int[] a = new int[b];
		for (int i=0; i<b; i++)
			a[i] = Integer.parseInt(in.readLine());

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int min = Integer.MAX_VALUE;
		
		for (int i=1; i<=n-k-1; i++) {
			int l = Arrays.binarySearch(a, i);
			int r = Arrays.binarySearch(a, i+k-1);
			System.out.println(l+" "+r);
			if(l<0 && r<0 && r-l==k-1) {
				min = 0; 
			}
			if(l<0) l = Math.abs(l) -1;
			if(r<0) r = Math.abs(r) -2;
			min = Math.min(min, r-l+1);
			System.out.println(min);
		}

		PrintWriter out = new PrintWriter(new FileWriter("maxcross.out"));
		out.println(min);
		out.close();
		in.close();
	}
}