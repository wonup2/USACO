import java.util.*;
import java.io.*;

public class measurement_silever {

	static Data[] a;
	static int n, g;
	static Map<Integer, Integer> cow, board;
	public static void main(String[] args) throws IOException {

		
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));		
		init();
		solve();		
		
		out.close();	
	}

	private static void init() throws IOException {
		BufferedReader in=new BufferedReader(new FileReader("measurement.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		cow = new HashMap<Integer, Integer>();	
		
		a = new Data[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			int date = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			a[i] = new Data(date, id, m);
			cow.put(id, g);
		}
		
		Arrays.sort(a);
		board = new TreeMap<Integer, Integer>();
		board.put(g, n);
		//System.out.println(Arrays.toString(a));
		//System.out.println(cow);
	}
	
	private static void solve() {
		int id = 0, measure = 0, milk = g, lastId = 0, lastMilk = 0;
		
		for(int i=0; i<n; i++) {
			id = a[i].id;
			milk = cow.get(id);
			measure = a[i].measure;
			
			
			if(board.containsKey(milk)) board.put(milk, board.get(milk)-1);
			
			milk += measure;
			
			cow.put(id, milk);
			
			
			
			
		}
	}
}

class Data implements Comparable<Data>{

	int date;
	int id;
	int measure;
	
	Data(int d, int c, int m){
		date = d;
		id = c;
		measure = m;
	}
	@Override
	public int compareTo(Data that) {
		return this.date - that.date;
	}
	
	public String toString() {
		return id+" "+measure;
	}
}