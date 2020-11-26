import java.util.*;
import java.io.*;

public class FEB_SIL_herding{

	static BufferedReader in;
	static PrintWriter out;
	static int n, a[];
	
	public static void main(String[] args) {
		try {
			in = new BufferedReader(new FileReader("herding.in"));
			n = Integer.parseInt(in.readLine());
			a = new int[n];
			for(int i=0; i<n; i++) 
				a[i] = Integer.parseInt(in.readLine());
			
			out = new PrintWriter(new FileWriter("herding.out"));
			solve();
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static void solve() {
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
		int min = min();
		int max = Math.max(a[n-2]-a[0], a[n-1]-a[1]) - (n-2);  //4 7 10 30   
		out.println(min+"\n"+max);
	}

	static int min(){
		if (a[n-2]-a[0] == n-2 && a[n-1]-a[n-2]>2) return 2;
		if (a[n-1]-a[1] == n-2 && a[1]-a[0]>2) return 2;
		int j=0, best=0;
		for (int i=0; i<n; i++) {
			//System.out.println(i+" "+j);
			//System.out.println(a[j+1]+" "+a[i] +" " +  (a[j+1]-a[i]) +" "+(n-1));
			while (j<n-1 && a[j+1]-a[i]<=n-1) {
				//System.out.println(a[j+1]+" "+a[i] +" " +  (a[j+1]-a[i]) +" "+(n-1));
				j++;
			}
			best = Math.max(best, j-i+1);
		}
		return n-best;
	}
}
