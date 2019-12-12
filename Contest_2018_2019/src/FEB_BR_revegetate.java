import java.util.*;
import java.io.*;
public class FEB_BR_revegetate {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, m;
	static HashSet<Integer> a[];
	static ArrayList<String> c[];
	
	public static void main(String[] args) throws IOException {
		try {
			init();
			solve();			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	static void init() throws IOException {
		in = new BufferedReader(new FileReader("revegetate.in"));
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new HashSet[n+1];
		c = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			a[i] = new HashSet<Integer>();
			c[i] = new ArrayList<String>();
			for(int j=1; j<=4; j++) c[i].add(j+"");
		}
		int cow=1;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			a[Integer.parseInt(st.nextToken())].add(cow);
			a[Integer.parseInt(st.nextToken())].add(cow);
			cow++;
		}
		in.close();

	}
	static void solve() throws IOException {
		String type = "";
		for(int i=1; i<=n; i++) {
			type = c[i].get(0);
			for(int j=i+1; j<=n; j++) {
				boolean ok = true; 
				for(int t:a[i]) {					
					if(a[j].contains(t)) ok = false;
				}
				if(!ok) c[j].remove(type);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for(int i=1; i<=n; i++)
			ans.append(c[i].get(0));
		
		out = new PrintWriter(new FileWriter("revegetate.out"));
		out.println(ans.toString());
		out.close();
	}
}
