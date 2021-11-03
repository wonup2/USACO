import java.util.*;
import java.io.*;

public class US_SIL_pairup {

	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static TreeMap<Integer, Integer> map;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("pairup.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		map = new TreeMap<Integer, Integer>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if(map.containsKey(y)) map.put(y, map.get(y)+x);			
			else map.put(y, x);
		}		
	}
	static void solve() {
		int ans = 0;
		
		while(!map.isEmpty()) {
			int a = map.firstKey();
			int b = map.lastKey();
			
			ans = Math.max(ans, a + b);
			
			if(map.get(a) > map.get(b)) {
				map.put(a, map.get(a) - map.get(b));
				map.remove(b);
			}else if(map.get(b) > map.get(a)) {
				map.put(b, map.get(b) - map.get(a));
				map.remove(a);
			}else {
				map.remove(a);
				map.remove(b);
			}
			
		}
		
		out.println(ans);
	}	
}
