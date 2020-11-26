import java.util.*;
import java.io.*;

public class berries {

	static int n, k, a[];
	static Scanner in;
	static PrintWriter out;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("berries.in"));
		out = new PrintWriter(new FileWriter("berries.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		//StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = in.nextInt();
		k = in.nextInt();
		a = new int[n];
		//st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)
			a[i] = in.nextInt();
		
		Arrays.sort(a);
	}
	
	static void solve() {
		int max = a[n-1];
		int r = 0;
		//System.out.println(max);
		for(int i=1; i<=max; i++) 
			r = Math.max(r, pick(i));
		
		out.println(r);		
	}
	
	static int pick(int x) {
		int r=0;
		ArrayList<Integer> t = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			int sum = 0;
			while(sum < a[i]) {
				if(a[i]-sum >=x) {
					t.add(x);
					sum+=x;
				}
				else {
					t.add(a[i]-sum);
					break;
				}
			}			
		}
		Collections.sort(t);
		Collections.reverse(t);
		//System.out.println(t);
		for(int j=k/2; j<k && j<t.size(); j++)
			r+=t.get(j);
	
		return r;
	}

}
