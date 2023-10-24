import java.util.*;
import java.io.*;


public class U19DEC_BR_lineup {

	static Scanner in;
	static PrintWriter out;
	static String cow[] = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
	static HashMap<String, Integer> m;
	static int n;
	static ArrayList<String> p, a;	
	
	static void permutation(String s) {
		
		if(s.length()==8) {
			p.add(s); return;
		}
		
		for(int i=0; i<8; i++) {
			if(!s.contains(i+"")) permutation(s+i);
		}		
	}
	
	
	
	static void init() {
		
		p = new ArrayList<String>();
		permutation("");
		
		n = in.nextInt();
		m = new HashMap<String, Integer>();
		for(int i=0; i<8; i++) m.put(cow[i], i);
		//System.out.println(m);

		a = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			int x = m.get(in.next());
			in.next();in.next();in.next();in.next();
			int y = m.get(in.next());
			a.add(x+""+y);
			a.add(y+""+x);
		}
		
		//System.out.println(a);
	}
	
	static void solve() {
		
		String per = "";
		for(String s:p) {
			
			boolean ok = true;
			for(int i=0; i<n*2; i+=2) {
				if(!s.contains(a.get(i)) && !s.contains(a.get(i+1))) {
					ok=false; break;
				}
			}
			
			if(ok) {
				per = s;
				break;
			}
		}
		
		//System.out.println(per);
		//07134526
		
		for(int i=0; i<8; i++) {
			int idx = per.charAt(i) - '0';
			out.println(cow[idx]);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("lineup.in"));
		out = new PrintWriter(new File("lineup.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

}
