import java.util.*;
import java.io.*;

public class DEC_SIL_measurement {
	
	static BufferedReader in;
	static PrintWriter out;
	static group a[];
	static int n, g, bMilk, bCow;
	static HashMap<Integer, Integer> cowMap;
	static TreeMap<Integer, Integer> milkMap;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("measurement.in"));
		out = new PrintWriter(new File("measurement.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		a = new group[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = new group(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		cowMap = new HashMap<Integer, Integer>();
		milkMap = new TreeMap<Integer, Integer>();
			
		milkMap.put(g, 1000000000);
		bMilk = g;
		bCow = 1000000000;
	}
	
	static void solve() {
		int curID=0, curMilk=0, curChange=0, maxMilk=0, maxCow=0, ans = 0;
		
		for(int i=0; i<n; i++) {
			
			curID = a[i].id;
			curMilk = cowMap.containsKey(curID)? cowMap.get(curID):g;
			curChange = a[i].change;
			
			milkMap.put(curMilk, milkMap.get(curMilk)-1);
			if(milkMap.get(curMilk)==0) milkMap.remove(curMilk);
						
			if(bMilk==curMilk) bMilk+=curChange;
			curMilk+=curChange;
			
			if(milkMap.containsKey(curMilk))
				milkMap.put(curMilk, milkMap.get(curMilk)+1);
			else milkMap.put(curMilk, 1);
			cowMap.put(curID, curMilk);			

			maxMilk = milkMap.lastKey();
			maxCow = milkMap.get(maxMilk);
			
			if(maxMilk!=bMilk || maxCow!=bCow) {
				ans++;
				bMilk = maxMilk;
				bCow = maxCow;
			}			
		}
		
		out.println(ans);
	}
	
	static class group implements Comparable<group>{
		int date, id, change;
		group(int d, int i, int c){
			date = d;
			id = i;
			change = c;
		}
		
		public String toString() {
			return date+" "+id+" "+change;
		}
		
		@Override
		public int compareTo(group arg0) {
			// TODO Auto-generated method stub
			return this.date - arg0.date;
		}		
	}
}
