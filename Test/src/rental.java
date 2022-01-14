import java.util.*;
import java.io.*;

public class rental {

	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, m, r;
	static long ans;
	static LinkedList<Integer> mart, cow, rental;

	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("rental.in"));
		out = new PrintWriter(new File("rental.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		ans = 0l;
		cow = new LinkedList<Integer>();
		mart = new LinkedList<Integer>();
		rental = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) cow.add(Integer.parseInt(in.readLine()));
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int id=Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			for(int j=0; j<id; j++) mart.add(cost);
		}
		for(int i=0; i<r; i++) rental.add(Integer.parseInt(in.readLine()));
		
		Collections.sort(cow, Collections.reverseOrder());
		Collections.sort(mart, Collections.reverseOrder());
		Collections.sort(rental, Collections.reverseOrder());
	}
	
	static void solve() {
		
		int profit[] = new int[n];
		
		//mart
		for(int i=0; i<n; i++) {
			int milk = cow.get(i);
			int money = 0;
			while(milk-->0) {
				money+=mart.remove(0);
				if(mart.size()==0) break;
			}
			
			profit[i]=money;
			if(mart.size()==0) break;

		}
				
		//rental
		for(int i=n-1; i>=0; i--) {
			if(rental.size()==0) break;			
			profit[i] = Math.max(profit[i], rental.get(0)); 
			rental.remove(0);			
		}
		

		for(int cost:profit)
			ans+=cost;
		
		out.println(ans);
	}	
}
