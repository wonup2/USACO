import java.util.*;
import java.io.*;

public class cowqueue {

	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static TreeMap <Integer, Integer> m = new  TreeMap <Integer, Integer>() ;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("cowqueue.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		int arrival = 0;
		int interview = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine()); //2 3
			arrival = Integer.parseInt(st.nextToken());
			interview = Integer.parseInt(st.nextToken());
			if(m.containsKey(arrival)) m.put(arrival, m.get(arrival)+interview);
			else m.put(arrival, interview);
		}		
	}	
	
	static void solve() {
		
		int time = 0;
		
		for(int key : m.keySet()) {
			if(time < key) time = key;			
			time += m.get(key);
		}
		
		out.println(time);
	}
}
