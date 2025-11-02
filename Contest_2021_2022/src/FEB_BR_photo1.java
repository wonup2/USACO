import java.util.*;
import java.io.*;

public class FEB_BR_photo1 {
	static int n, a[];
	static HashMap<Integer, Integer> b;
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException{
		n= Integer.parseInt(in.readLine());
		a = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		b = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) b.put(Integer.parseInt(st.nextToken()), i);

	}
	
	static void solve() {

		boolean move[] = new boolean[n+1];
		int cnt=0;
		for(int j=0; j<n; j++) {
			int key = a[j];
			if(move[key]) continue;

			int indKey = b.get(key);			
			
			for(int i=j+1; i<n; i++) {
				int indNext = b.get(a[i]);
				
				if(indKey > indNext) {
					if(!move[a[i]]) {
						move[a[i]] = true;	
						cnt++;
					}
				}
			}
		}
					
		System.out.println(cnt);
	}
}
