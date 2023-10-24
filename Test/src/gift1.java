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
	static int n, money, cnt, gift, remain;
	static String giver, name;
	static LinkedHashMap<String, Integer> map;	
	
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("gift1.in"));
		out = new PrintWriter(new File("gift1.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		map = new LinkedHashMap<String, Integer>();
		
		for(int i=0; i<n; i++) map.put(in.next(), 0);
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			
			giver = in.next();
			money = in.nextInt();
			cnt = in.nextInt();
			if(cnt==0) continue;
			
			remain = money % cnt;
			gift = money / cnt;
			
			map.put(giver, map.get(giver)-money+remain);
			
			for(int j=0; j<cnt; j++) {
				name = in.next();
				map.put(name, map.get(name) + gift);
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		for(String key:map.keySet())
			sb.append(key).append(" ").append(map.get(key)).append("\n");
		
		out.print(sb.toString());
	}
}
