import java.util.*;
import java.io.*;

public class guess {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static Map<String, Integer> m;
	static Set<String>[] a;
	
	public static void main(String[] args) {
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		try {
			in = new Scanner(new File("guess.in"));
			out = new PrintWriter(new File("guess.out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		n=in.nextInt();
		m=new HashMap<String, Integer>();		
		a=new HashSet[n];
		for(int i=0; i<n; i++) {
			a[i]=new HashSet<String>();
			in.next();
			int temp = in.nextInt();
			while(temp-->0) {
				String s=in.next();
				a[i].add(s);
				if(m.containsKey(s)) m.put(s, m.get(s)+1);
				else m.put(s, 1);
			}
		}
		System.out.println(m);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int max=0;
		for(int i=0; i<n; i++) {	
			int cnt=0;
			for(String s:a[i]) {
				if(m.get(s)>1) cnt++;	
				System.out.println(i+" " + s +" " + m.get(s) + " " + cnt);
			}
			max=Math.max(max, cnt);
		}
	
		out.println(max+1);
	}
}
