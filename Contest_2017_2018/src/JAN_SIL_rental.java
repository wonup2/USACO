
import java.io.*;
import java.util.*;

public class JAN_SIL_rental {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N, M, R;
	static int [] profit;
	static int [] rental;
	static int [] gallons;
	static price store [];

	public static void main(String[] args) {
		
		try {
			init();
	        solve();
	        out.close();
	        in.close();
	    }
	    catch(Exception e) {
	        System.out.println("Error");
	        e.printStackTrace();
	    }

	}
	
	public static void init () throws IOException {
		
		in = new BufferedReader(new FileReader ("rental.in"));
		out = new PrintWriter (new File ("rental.out"));
		StringTokenizer st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		rental = new int [R];
		profit = new int [N];
		gallons = new int [N];
		int [] temp = new int [N];
		for (int i = 0; i < N; i++) temp[i] = Integer.parseInt(in.readLine());
	
		store = new price[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer (in.readLine());
			int g = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			store[i] = new price (g, c);
		}
		
		for (int i = 0; i < R; i++)	rental[i] = Integer.parseInt(in.readLine());
		for (int i = N-1; i >= 0; i--) gallons [i] = temp[N-i-1];

		Arrays.sort(rental);
		Arrays.sort(temp);	
		Arrays.sort(store);		
	}
	
	static void solve () {
		
		int cur = 0;
		for (int i = 0; i < N; i++) {
			while (cur < M && gallons[i] > 0) {
				int usedGal = Math.min(gallons[i], store[cur].gallon);
				int price = store[cur].cents;
				profit[i] += usedGal*price;
				gallons[i] -= usedGal;
				store[cur].gallon -= usedGal;
				if (store[cur].gallon == 0) {
					cur++;
				}
			}
		}
		//System.out.println(Arrays.toString(profit));
		for (int i = N-1, j = R-1; i >= 0 && j >= 0; i--, j--) 
			profit [i] = Math.max(profit[i], rental[j]);
		
		
		long sum = 0;
		for (int i = 0; i < N; i++) 
			sum += profit[i];
		
		out.println(sum);
	}
	
	static class price implements Comparable <price>{
		
		public int gallon;
		public int cents;
		
		public price (int g, int c) {
			gallon = g;
			cents = c;
		}
		public int compareTo(price that) {
			return that.cents - this.cents;
		}
		public String toString() {
			return gallon + " " + cents;
		}
		
	}

}


