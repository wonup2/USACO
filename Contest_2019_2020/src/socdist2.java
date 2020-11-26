// Arup Guha
// 4/12/2020
// Solution to 2020 March Bronze USACO Problem: Social Distancing II

import java.util.*;
import java.io.*;

public class socdist2 {
	
	public static int n;
	public static ArrayList<Integer> locs;
	
	public static void main(String[] args) throws Exception {
		
		// Get input.
		Scanner stdin = new Scanner(new File("socdist2.in"));
		n = stdin.nextInt();
		
		// Read in all the cows and sort.
		cow[] list = new cow[n];
		for (int i=0; i<n; i++) {
			int x = stdin.nextInt();
			int inf = stdin.nextInt();
			list[i] = new cow(x, inf);
		}
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		
		// Will update - max possible infection radius.
		int maxr = 10000000;
		
		// Look for uninfected cows.
		for (int i=0; i<n; i++) {
		
			// Update the largest the infection radius could be - from left.
			if (i > 0 && list[i-1].infected && !list[i].infected) 
				maxr = Math.min(list[i].x-list[i-1].x-1, maxr);
			
			// And right.
			if (i <n-1 && !list[i].infected && list[i+1].infected) 
				maxr = Math.min(list[i+1].x-list[i].x-1, maxr);
		}
		
		System.out.println(maxr);
		// Now, we infect left to right.
		int res = 0;
		boolean flag = true;
		
		// Go through all.
		for (int i=0; i<n; i++) {
			
			// Automatically skip but note next infected cow must count.
			if (!list[i].infected) {
				flag = true;
				continue;
			}
			
			// If you are a new group, you count, or if you are too far from the last cow.
			if (flag || list[i].x - list[i-1].x > maxr) {
				res++;
				flag = false;
			}
		}
		
		// Output result.
		PrintWriter out = new PrintWriter(new FileWriter("socdist2.out"));
		out.println(res);
		out.close();		
		stdin.close();
	}

}

class cow implements Comparable<cow> {
	public int x;
	public boolean infected;
	
	public cow(int myx, int i) {
		x = myx;
		infected = (i == 1);
	}
	
	public int compareTo(cow other) {
		return x - other.x;
	}
	public String toString() {
		return x+" "+infected;
	}
}