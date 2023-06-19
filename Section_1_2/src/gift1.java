/*
ID: wonup21
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

public class gift1 {
	
	static Scanner in;
	static PrintWriter out;
	static int NP;
	static LinkedHashMap<String, Integer> group;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("gift1.in"));
		out = new PrintWriter(new File("gift1.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		group = new LinkedHashMap<String, Integer>();
		
		NP = in.nextInt(); in.nextLine();
		for(int i=0; i<NP; i++) {
			group.put(in.next(), 0);
		}
		
		//System.out.println(group);
	}
	
	static void solve() {
		
		for(int i=0; i<NP; i++) {
			
			String giver = in.next();
			int money = in.nextInt();
			int num = in.nextInt();
			
			if(num==0) continue;
			
			int gift = money / num;
			int rem = money % num;
			
			for(int j=0; j<num; j++) {
				String rec = in.next();
				group.put(rec, group.get(rec) + gift);
			}
			
			group.put(giver, group.get(giver)-money+rem);
		}
		
		//output
		for(String key:group.keySet()) {
			out.println(key + " " + group.get(key));
		}		
	}	
}
