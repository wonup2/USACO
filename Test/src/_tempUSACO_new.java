import java.util.*;
import java.io.*;


public class _tempUSACO_new {

	static Scanner in;
	//static BufferedReader in;
	//static StringTokenizer st;
	static char[][] a;
	static TreeSet<Character> [] b;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		//in = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
		
		in.close();
	}

	static void init() throws IOException {
	
		
		
		
		
		TreeMap<Integer, ArrayList> m = new TreeMap<Integer, ArrayList>();
				
		m.put(1, new ArrayList<String>());
		m.put(2, new ArrayList<String>());

		m.get(1).add("aaa");
		m.get(2).add("bbb");
		m.get(1).add("ccc");
		
		System.out.println(m);
		
	}
	
	static void solve() {
		
		b = new TreeSet[8];
		
		for(int i=0; i<8; i++)
			b[i] = new TreeSet<Character>();
		
		b[0].add(a[0][0]);
		b[0].add(a[0][1]);
		b[0].add(a[0][2]);
		
		b[1].add(a[1][0]);
		b[1].add(a[1][1]);
		b[1].add(a[1][2]);
		
		b[2].add(a[2][0]);
		b[2].add(a[2][1]);
		b[2].add(a[2][2]);
		
		System.out.println(Arrays.toString(b));
		
		
		
		
		
		
		
		
		
		
		
	}
}
