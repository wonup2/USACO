import java.util.*;
import java.io.*;

public class US_BR_tracing {
	
	final public static int NOSOL = 1000;
	
	public static int n;
	public static int numShakes;
	public static boolean[] infected;
	public static shake[] list;
	static PrintWriter out;
	public static void main(String[] args) throws Exception {
		
		// Get input - store all data.
		Scanner stdin = new Scanner(new File("tracing.in"));
		out = new PrintWriter(new FileWriter("tracing.out"));

		n = stdin.nextInt();
		numShakes = stdin.nextInt();
		
		// Mark who is infected.
		infected = new boolean[n];
		String line = stdin.next();
		for (int i=0; i<n; i++)
			infected[i] = line.charAt(i) == '1';
		
		// Read in all interactions.
		list = new shake[numShakes];
		for (int i=0; i<numShakes; i++) {
			int t = stdin.nextInt();
			int u = stdin.nextInt()-1;
			int v = stdin.nextInt()-1;
			list[i] = new shake(t, u, v);
		}
		Arrays.sort(list);
		
		int numPos = 0, min=-1, max=-1;
		
		// Try each cow as cow zero.
		for (int i=0; i<n; i++) {
			
			// Skip.
			if (!infected[i]) continue;
			
			// Run it.
			int[] tmp = sim(i);

			// Have a solution.
			if (tmp[0] != NOSOL) {
				numPos++;
				if (min == -1 || tmp[0] < min) min = tmp[0];
				max = Math.max(max, tmp[1]);
			}
			
		}
		
	
		// Special case.
		if (max == 250)
			out.println(numPos+" "+min+" Infinity");
		
		// Regular output.
		else
			out.println(numPos+" "+min+" "+max);
		
		out.close();		
		stdin.close();
	}
	
	// precond: u has infection.
	// return bounds on k with u being patient 0.
	public static int[] sim(int u) {
	
		int mink = NOSOL;
		int maxk = 0;
		
		// Try all k's.
		for (int k=0; k<251; k++) {
		
			// Initial conditions.
			boolean[] cur = new boolean[n];
			cur[u] = true;
			int[] counts = new int[n];

			// Go though each shake.
			for (int i=0; i<numShakes; i++) {
								
				// Just add 1 to each count.
				if (cur[list[i].u] && cur[list[i].v]) {
					counts[list[i].u]++;
					counts[list[i].v]++;
				}
				
				// u infects v.
				else if (cur[list[i].u] && !cur[list[i].v] && counts[list[i].u] < k) {
					cur[list[i].v] = true;
					counts[list[i].u]++;
				}
				
				// v infects u.
				else if (cur[list[i].v] && !cur[list[i].u] && counts[list[i].v] < k) {
					cur[list[i].u] = true;
					counts[list[i].v]++;				
				}		
				out.println(u +" " + i + " "+ k);
				out.println(Arrays.toString(cur));
				out.println(Arrays.toString(counts));
			}

			boolean ok = true;
			for (int i=0; i<n; i++)
				if (cur[i] != infected[i])
					ok = false;
					
			// If so, store.
			if (ok) {
				out.println("----------");
				out.println(Arrays.toString(cur));
				out.println(Arrays.toString(counts));
				out.println("----------");

				mink = Math.min(mink, k);
				maxk = Math.max(maxk, k);
			}		
		}

		System.out.println(mink+" "+maxk);
		// This is what we got.
		return new int[]{mink, maxk};
	}
}

class shake implements Comparable<shake> {
	public int t;
	public int u;
	public int v;
	
	public shake(int myt, int myu, int myv) {
		t = myt;
		u = Math.min(myu, myv);
		v = Math.max(myu, myv);
	}
	
	public int compareTo(shake other) {
		return t - other.t;
	}
	
	public String toString() {
		return t+" "+ u +" "+v;
	}
}