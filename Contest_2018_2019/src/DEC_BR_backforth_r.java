import java.io.*;
import java.util.*;

public class DEC_BR_backforth_r{

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static ArrayList<Integer> a, b;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("backforth.in"));
		out = new PrintWriter(new OutputStreamWriter(System.out));
	
		a = new ArrayList<>();
		b = new ArrayList<>();
		
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<10; i++) a.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(in.readLine());
		for (int i=0; i<10; i++) b.add(Integer.parseInt(st.nextToken()));
	
		solve(4, a, b, 1000, 1000);
		
		out.println(set.size());
		out.close();
	}

	private static void solve(int depth, ArrayList<Integer> source, ArrayList<Integer> dest, int tankA, int tankB) {
		if (depth == 0) {
			set.add(tankA);
			return;
		}
		
		for (int i = 0; i < source.size(); i++) {
			ArrayList<Integer> a = new ArrayList<>(source);
			ArrayList<Integer> b = new ArrayList<>(dest);
			b.add(source.get(i)); 
			a.remove(i);
			solve(depth - 1, b, a,  tankB - source.get(i), tankA + source.get(i));
		}
	}
} 