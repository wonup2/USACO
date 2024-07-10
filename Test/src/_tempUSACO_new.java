import java.util.*;
import java.io.*;


public class _tempUSACO_new {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
		
		in.close();
	}

	static void init() throws IOException {
		
		HashSet<Integer> set = new HashSet<Integer>();
		int n = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<n; i++)
			set.add(Integer.parseInt(st.nextToken()));  
		
		//1000000000
		
		System.out.println(set.size());
		
	}
	
	static void solve() {
		
	}
}
