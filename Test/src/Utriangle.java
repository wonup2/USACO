import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;
public class Utriangle {
	static String file = "test";
	static Scanner in;
	static PrintWriter out;
	static int n, area, ans;
	static int[] x, y;
	static TreeSet<Integer> X, Y;
	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new File(file + ".in"));
		out = new PrintWriter(new File(file + ".out"));
		
		init();
		solve();
		
		in.close();
		out.close();

	}
	
	public static void init() {
		
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		
		for(int i = 0; i<n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
	}
	
	public static void solve() {
		int ans = 0;
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				for(int k = j+1; k<n; k++) {
					
					if(check(i,j,k)) {
						int area = (X.last() - X.first())*(Y.last() - Y.first());
						ans = Math.max(ans, area);
					}
				}
			}
		}
		
		out.println(ans);
	
	}
	
	static boolean check(int i, int j, int k) {
		
		X= new TreeSet<Integer>();
		Y = new TreeSet<Integer>();
		
		X.add(x[i]); X.add(x[j]); X.add(x[k]); 
		Y.add(y[i]); Y.add(y[j]); Y.add(y[k]);
		
		return (X.size()==2 && Y.size()==2);
	}

}