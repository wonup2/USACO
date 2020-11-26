import java.io.*;
import java.util.*;

public class JAN_BR_photo {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, a[];
	static TreeMap<Integer, Integer> m;
	static String num="";
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("photo.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		init();
		solve();
		in.close();
		out.close();
		
	}

	static void init() throws NumberFormatException, IOException {
		
		n=Integer.parseInt(in.readLine());
		a=new int[n];
		m = new TreeMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n-1; i++) a[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<n; i++) {
			int j = a[0]-i;						
			if(i!=j && j>0 && i+j==a[0]) m.put(i,j);
		}
		//System.out.println(m);
	}
	
	static void solve() {
		
		ArrayList<Integer>ans = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int k:m.keySet()) {
			ans = new ArrayList<Integer>();
			ans.add(k);
			ans.add(m.get(k));
			
			for(int i=1; i<n-1; i++) {
				int x = ans.get(i);
				int y = a[i]-x;

				if(ans.contains(y) || y<1) break;
			
				ans.add(y);
			}

			if(ans.size()==n) {
				sb.append(ans.get(0));
				for(int i=1; i<ans.size(); i++)
					sb.append(" ").append(ans.get(i));
				break;
			}
		}		
		out.println(sb.toString());
	}
}
