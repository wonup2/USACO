import java.io.*;
import java.util.*;

public class photo {
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
		for(int i=0; i<n-1; i++) {
			a[i]=Integer.parseInt(st.nextToken());
			int x = i+1;
			int y = a[0]-x;
			if(x!=y && y>0 && x+y==a[0]) m.put(x, y);
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
			boolean flag=true;
			
			for(int i=1; i<n-1; i++) {
				int x = ans.get(i);
				int y = a[i]-x;
				//System.out.println(x+" "+y);
				if(y<1) break;
				if(ans.contains(y)) {
					flag=false;					
					break;
				}
				ans.add(y);
			}
			//System.out.println(ans);
			if(flag&&ans.size()==n) {
				sb.append(ans.get(0));
				for(int i=1; i<ans.size(); i++)
					sb.append(" ").append(ans.get(i));
				break;
			}
		}
		
		
		out.println(sb.toString());
	}

}
