import java.util.*;
import java.io.*;


public class triangles {

	static Scanner in;
	//static BufferedReader in;
	//static StringTokenizer st;
	static PrintWriter out;
	static String file = "triangles";
	static int x[], y[], n;
	static TreeSet<Integer> xp, yp;
	public static void main(String[] args) throws IOException {

		//in = new BufferedReader(new FileReader(file + ".in"));
		
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		n = in.nextInt();
		x = new int[n];
		y = new int[n];
		for(int i=0; i<n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		
		//System.out.println(Arrays.toString(x));
		//System.out.println(Arrays.toString(y));

	}
	
	static void solve() {
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					if(isAvailable(i, j, k)) {
						int area = (xp.last()-xp.first()) * (yp.last()-yp.first());
						//System.out.println(area);
						max = Math.max(max, area);
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static boolean isAvailable(int i, int j, int k) {
		xp = new TreeSet<Integer>(); yp = new TreeSet<Integer>();
			
		xp.add(x[i]); xp.add(x[j]); xp.add(x[k]);
		yp.add(y[i]); yp.add(y[j]); yp.add(y[k]);
		
		return xp.size()==2 && yp.size()==2;
	}
}
