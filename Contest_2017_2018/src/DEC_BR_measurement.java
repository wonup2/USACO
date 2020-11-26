import java.util.*;
import java.io.*;

public class DEC_BR_measurement {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static TreeMap<Integer, HashMap<Integer, Integer>> a;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		in = new Scanner(new FileReader("measurement.in"));

		n = in.nextInt();
		a = new TreeMap<Integer, HashMap<Integer, Integer>> ();
		for(int i=0; i<n; i++) {
			int num = in.nextInt();
			HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
			h.put(nCow(in.next()), in.nextInt());
			a.put(num,h);
		}		
	}
	static void solve() throws IOException {
		int[] milk = {7,7,7};
		int max = 0; int cng = 0;
		boolean[] x = new boolean[3];
		boolean[] y = new boolean[3];
		
		for(HashMap<Integer, Integer> h:a.values()) {
			x = y.clone();

			milk[h.keySet().hashCode()] += h.get(h.keySet().hashCode());
			max = Math.max(milk[0],Math.max(milk[1],milk[2]));
			
			for(int i=0; i<3; i++) {
				if(milk[i]==max) y[i]=true;
				else y[i] = false;
			}
			
			if(x[0]!=y[0]||x[1]!=y[1]||x[2]!=y[2]) cng++;
		}
		
		out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		out.println(cng);
		out.close();
	}
	
	static int nCow(String s) {
		if(s.equals("Bessie")) return 0;
		else if(s.equals("Elsie")) return 1;
		else return (Integer)2;
	}
}
