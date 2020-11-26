import java.util.*;
import java.io.*;

public class measurement {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, g, ans;
	static records[] log;
	static HashMap<Integer, Integer> cowMap;
	static TreeMap<Integer, Integer> milkMap;
	static final int max = 1000000000;

	
	public static void main(String[] args) throws IOException{
		
		init();
		solve();
		in.close(); out.close();
		
	}
	
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("measurement.in"));
		out = new PrintWriter(new FileWriter("measurement.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		ans = 0;
		log = new records[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			log[i] = new records(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		cowMap = new HashMap<Integer, Integer>();
		milkMap = new TreeMap<Integer, Integer>();
		milkMap.put(g, max);
		Arrays.sort(log);
		System.out.println(Arrays.toString(log));
	}
	
	public static void solve() {
		int boardMilk = g;
		int boardCow = max;
		for(int i = 0; i < n; i++) {
			int currID = log[i].cow;
			int currMilk = 0;
			int currChange = log[i].change;
			if(cowMap.get(currID)==null) {
				currMilk = g;
			}
			else {
				currMilk = cowMap.get(currID);
			}
			
			if(currMilk == boardMilk) {
				boardMilk += currChange;
			}
			milkMap.put(currMilk, milkMap.get(currMilk)-1);
			if(milkMap.get(currMilk)==0) milkMap.remove(currMilk);
			
			currMilk += currChange;
			if(milkMap.get(currMilk)==null) {
				milkMap.put(currMilk, 1);
			}
			else {
				milkMap.put(currMilk, milkMap.get(currMilk)+1);
			}
			cowMap.put(currID, currMilk);
			
			int maxMilk = milkMap.lastKey();
			int maxCow = milkMap.get(maxMilk);
			
			if(maxMilk != boardMilk || maxCow != boardCow) {
				ans++;
				boardMilk = maxMilk;			
				boardCow = maxCow;
				
			}

		}
		out.println(ans);
	}
	
	
	static class records implements Comparable<records>{
		int day;
		int cow;
		int change;
		
		records (int d, int c, int c1){
			day = d;
			cow = c;
			change = c1;
		}
		
		public String toString() {
			return day + " " + cow + " " + change;
		}
		
		@Override
		public int compareTo(records o) {
			return this.day - o.day;
		}
		
	}
	
}
