import java.io.*;
import java.util.*;

public class US_BR_MoreCowPhotos {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int t, n, maxHeight;
	static HashMap<Integer, Integer> map;
		
	static void init() throws IOException{
		
		n = Integer.parseInt(in.readLine());
		
		map = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(in.readLine());
		 
		for(int i=0; i<n; i++) {
			int h = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(h, maxHeight);
			map.put(h, map.getOrDefault(h, 0)+1);
		}	
	}
	
	static void solve() {
		
		int ans = 0;

		for(int value:map.values()) {
			if(value>=2) ans+=2;
		}
		
		if(map.get(maxHeight)>=2) ans--;
		else ans++;
		
		sb.append(ans).append("\n");
	}
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		
		while(t-->0) {
			maxHeight = 0;
			init();
			solve();
		}
		
		System.out.print(sb.toString());
		
        in.close();
	}
}