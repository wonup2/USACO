import java.util.*;
import java.io.*;

public class DEC_BR_notlast {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static Map<String, Integer> a;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		in = new Scanner(new File("notlast.in"));
		out = new PrintWriter(new File("notlast.out"));
		a = new HashMap<String, Integer>();
		n = in.nextInt();
		
		while(n-->0) {
			String key = in.next();
			if(a.containsKey(key)) a.put(key, a.get(key)+in.nextInt());
			else a.put(key, in.nextInt());
		}	
	}

	static void solve(){
		
		Map<Integer, String> b = new TreeMap<Integer, String>();
		for(String s:a.keySet()) {
			int key = a.get(s);
			if(b.containsKey(key)) b.put(key, b.get(key)+" "+key);
			else b.put(key, s);
		}
	
		ans = "";
		int i=0;
		for(int key:b.keySet()) {
			ans = b.get(key);			
			i++;
			if(i==2) break;
		}
		
		if(ans.indexOf(" ") > 0) ans="Tie";

		out.println(ans);
	}
}
