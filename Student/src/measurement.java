import java.util.*;
import java.io.*;

class cows implements Comparable<cows> {
	
	int day;
	int cow;
	int milk;
	
	cows (int day, int cow, int milk) {
		this.day = day;
		this.cow = cow;
		this.milk = milk;
	}
	
	public int compareTo(cows that) {
		if (this.day > that.day)
			return 1;
		else
			return -1;
	}
	
	public String toString() {
		return this.day + " " + this.cow + " " + this.milk;
	}
}

public class measurement {
	
	static int n, g, count, max;
	static cows[] list;
	static Map<Integer, Integer> a;
	static TreeMap<Integer, Integer> b;
	static BufferedReader in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader(new File("measurement.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		try {
			init();
			out.println(solve());
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() throws IOException {
		StringTokenizer br = new StringTokenizer(in.readLine());
		n = Integer.parseInt(br.nextToken());
		g = Integer.parseInt(br.nextToken());
		a = new HashMap<Integer, Integer>();
		b = new TreeMap<Integer, Integer>();
		b.put(g, n);
		list = new cows[n];
		for (int i = 0; i < n; i++) {
			br = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(br.nextToken());
			int c = Integer.parseInt(br.nextToken());
			int m = Integer.parseInt(br.nextToken());
			list[i] = new cows(d, c, m);
			a.put(c, g);
		}
		Arrays.sort(list);
		count = 0;
		max = g;
		in.close();
	}
	
	static int solve() {
		
		int onBoardCount =n;
		int onBoardMilk = g;
		b.put(g, n);
		
		for (int i = 0; i < n; i++) {
						
			onBoardCount = b.lastEntry().getValue();  	

			int currId = list[i].cow;
			int currMilk = a.get(currId);			

			if(b.get(currMilk) == 1) b.remove(currMilk);
			else b.put(currMilk, b.get(currMilk)-1);
			
			if(currMilk == max) onBoardMilk = max + list[i].milk;

			currMilk += list[i].milk;  
			a.put(currId, currMilk);
			
			if(b.containsKey(currMilk))	b.put(currMilk, b.get(currMilk)+1);
			else b.put(currMilk, 1);

			max= b.lastKey();  			
			
			if(b.lastEntry().getValue() != onBoardCount || max!= onBoardMilk) {
				count++; onBoardMilk = max;
			}

		}
		
		return count;
	}

}
