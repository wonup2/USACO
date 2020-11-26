import java.util.*;
import java.io.*;

public class JAN_BR_nolast {

	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static HashMap<String , Integer> cow = new HashMap<String , Integer>();	
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("notlast.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws NumberFormatException, IOException {
		
		cow.put("Bessie", 0);
		cow.put("Daisy", 0);
		cow.put("Gertie", 0);
		cow.put("Annabelle", 0);
		cow.put("Maggie", 0);
		cow.put("Henrietta", 0);
		cow.put("Elsie", 0);

		int n = Integer.parseInt(in.readLine());
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			int milk = Integer.parseInt(st.nextToken()) + cow.get(name);
			cow.put(name, milk);
		}
	}
	
	static void solve() {
		TreeMap<Integer, String> x = new TreeMap<Integer, String>();	
		
		for(String key: cow.keySet()) {
			int val = cow.get(key);
			if(x.containsKey(val)) key = x.get(val) + ","+ key;
			
			x.put(val, key);
		}		
		
		if(x.size()>1) x.remove(x.firstKey());
		
		String name = x.get(x.firstKey());
		if(name.contains(",")) out.println("Tie");
		else out.println(name);
	}
}
