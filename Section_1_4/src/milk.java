/*
ID: wonup21
LANG: JAVA
TASK: milk
*/



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class milk {
	
	static BufferedReader in;
	static PrintWriter out;
	static int gal, n;
	static TreeMap<Integer, Integer> m;
	
	public static void main(String[] args) throws Exception {
		try {
			in=new BufferedReader(new FileReader("milk.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
			init();
			out.println(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	static void init() throws IOException {
		m = new TreeMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		gal = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int i=n;
		while(i-->0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(m.containsKey(a)) m.put(a, m.get(a)+b);
			else m.put(a, b);
		}
	}
	static int solve() {
		int money = 0;

		for(int i:m.keySet()) {
			gal-=m.get(i);
			money+=i*m.get(i);
			if(gal<=0) {
				money+=gal*i;
				break;
			}
		}
		return money;
	}
}
