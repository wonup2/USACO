import java.io.*;
import java.util.*;
public class DEC_SIL_citystate {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static Map<String, Long> a;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("citystate.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		a = new HashMap<String, Long>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String city = st.nextToken();
			String state = st.nextToken();
			
			if(!city.substring(0, 2).equals(state)) {
				String key = city.substring(0, 2) + state;
				if(!a.containsKey(key)) {
					a.put(key, 0L);
				}
				a.put(key, a.get(key) + 1);
			}
		}
		System.out.println(a);
	}
	
	static void solve() {
		long ret = 0;
		for(String key: a.keySet()) {
			String otherKey = key.substring(2) + key.substring(0, 2);
			System.out.println(otherKey);
			if(a.containsKey(otherKey)) {
				ret += a.get(key) * a.get(otherKey);
			}
		}
		
		out.println(ret / 2);
	}	
}