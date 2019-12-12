import java.util.*;
import java.io.*;

class schedule implements Comparable<schedule> {
	
	int time;
	int cow;
	
	schedule(int time, int cow) {
		this.time = time;
		this.cow = cow;
	}
	
	public int compareTo(schedule that) {
		return this.time - that.time;
	}
	
	public String toString() {
		return this.time + " " + this.cow;
	}
}

public class lifeguards {

	static BufferedReader in;
	static PrintWriter out;
	static int n, start, end;
	static schedule[] list;
	static ArrayList<Integer> board;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File("lifeguards.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		try {
			init();
			//solve();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		list = new schedule[n*2];
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			StringTokenizer br = new StringTokenizer(in.readLine());
			list[2*i] = new schedule(Integer.parseInt(br.nextToken()), i);
			System.out.println(Arrays.toString(list));
			list[2*i+1] = new schedule(Integer.parseInt(br.nextToken()), i);
			
		}
		board = new ArrayList<Integer>();
		
		Arrays.sort(list);
		
	}
	
	public static void solve() {
		 
	}
}
