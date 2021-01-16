import java.util.*;
import java.io.*;

public class FEB_SIL_maxcross {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer tok = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tok.nextToken());
		int k = Integer.parseInt(tok.nextToken());
		int b = Integer.parseInt(tok.nextToken());

		// Initially all good.
		int[] a = new int[n];
		Arrays.fill(a, 1);  
		System.out.println(Arrays.toString(a));
		// Set the bad ones.
		for (int i=0; i<b; i++)
			a[Integer.parseInt(in.readLine())-1] = 0; 
		System.out.println(Arrays.toString(a));

		// Get sum of first goal items.
		int cur = 0;
		for (int i=0; i<k; i++)	cur += a[i];

		// Set up best streak of goal.
		int best = cur;
		System.out.println(best);
		// Sweep across, keeping interval of size goal by sub last, adding next.
		for (int i=k; i<n; i++) {
			cur += (a[i] - a[i-k]);
			best = Math.max(best, cur);
			System.out.println(best);

		}

		PrintWriter out = new PrintWriter(new FileWriter("maxcross.out"));
		out.println(k-best);
		out.close();
		in.close();
	}
}