/*
ID: wonup21
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
	
	static BufferedReader in;
	static PrintWriter out;
	static String file = "gift1";
	static StringTokenizer st;
	
	static int n, money, gift, num, rem;
	static LinkedHashMap<String, Integer> m;
	static String giver, rec;
	
	public static void main (String [] args) throws IOException {
		
		in = new BufferedReader(new FileReader(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		init();
		//solve();
		
		in.close();
		out.close();    
	}    
  
	static void init() throws IOException  {
		
		n = Integer.parseInt(in.readLine());
		m = new LinkedHashMap<String, Integer>();
		for(int i=0; i<n; i++) m.put(in.readLine(), 0);
		
		for(int i=0; i<n; i++) solve();
		
		for(String key:m.keySet()) 
			out.println(key + " " + m.get(key));		
	}
	
	static void solve() throws IOException{
		
		giver = in.readLine();		
		st = new StringTokenizer(in.readLine());		
		money = Integer.parseInt(st.nextToken());		
		num = Integer.parseInt(st.nextToken());		
		if(num==0) return; //<------
		
		gift = money / num;		
		rem = money % num;
		
		m.put(giver, m.get(giver) - money + rem);		
		for(int i=0; i<num; i++) {
			rec = in.readLine();
			m.put(rec, m.get(rec) + gift);
		}
	}
}