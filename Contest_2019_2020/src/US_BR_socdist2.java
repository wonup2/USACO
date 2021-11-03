import java.util.*;
import java.io.*;

public class US_BR_socdist2 {
	
	static Scanner in;
	static PrintWriter out;
	static ArrayList<Pair> a;
	static int n;
	
	public static void main(String[] args) throws IOException {
		in=new Scanner(new File("socdist2.in"));
		out=new PrintWriter(new File("socdist2.out"));
		init();
		solve();
		in.close();
		out.close();		
	}
	
	static void init() {
		a = new ArrayList<Pair>();
		n=in.nextInt();
		for(int i=0; i<n; i++) {
			a.add(new Pair(in.nextInt(), in.nextInt()==1? true:false));
		}
		Collections.sort(a);
	}

	static void solve() {

		int r=1000000;
		for(int i=1; i<a.size()-1; i++) {
			Pair pre = a.get(i-1);
			Pair cur = a.get(i);
			Pair nxt = a.get(i+1);
			if(pre.s && !cur.s) r = Math.min(cur.x-pre.x, r);
			if(!cur.s && nxt.s) r = Math.min(nxt.x-cur.x, r);		
		}

		//System.out.println(r);
		
		int res = 0;
		boolean flag = false;
		
		// Go through all.
		for (int i=0; i<n; i++) {
			
			if (!a.get(i).s) {
				flag = false;
				continue;
			}
			
			// If you are a new group, you count, or if you are too far from the last cow.
			if (!flag || a.get(i).x - a.get(i-1).x >= r) {
				res++;
				flag = true;
			}
		}
		
		out.println(res);
	}
		 
}
class Pair implements Comparable<Pair>{
	int x;
	boolean s;
	Pair(int x, boolean s){
		this.x=x;
		this.s=s;
	}
	@Override
	public int compareTo(Pair that) {			
		return this.x-that.x;
	}
	public String toString() {
		return x+" "+s;
	}
}