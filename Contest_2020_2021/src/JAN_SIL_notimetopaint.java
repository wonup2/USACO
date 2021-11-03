import java.util.*;
import java.io.*;

public class JAN_SIL_notimetopaint {

	static BufferedReader in;
	static HashMap<Character, Integer> a;
	static StringTokenizer st;
	static int n, m, ans, prefix[], suffix[];
	static String s;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = in.readLine();
		
		a = new HashMap<Character, Integer>();
		for(int i='A'; i<='Z'; i++) a.put((char)i, 0);
		
		prefix = new int[n+1];
		suffix = new int[n+1];
	}
	
	static void solve() throws IOException {

		char cur = s.charAt(0);
		
		for(int i=1; i<=n; i++) {
			cur = s.charAt(i-1);
			prefix[i] = prefix[i-1];
			boolean hasLighter = false;
			
			if(a.get(cur)==0) hasLighter = true;
			else {
				for(char c:a.keySet()) 
					if(c < cur && a.get(c) > a.get(cur)) hasLighter = true;				
			}
			if(hasLighter) prefix[i]++;
			
			a.put(cur, i);
		}
		
		System.out.println(Arrays.toString(prefix));
		for(int i='A'; i<='Z'; i++) a.put((char)i, n);
		
		for(int i=n-1; i>=0; i--) {
			cur = s.charAt(i);
			suffix[i] = suffix[i+1];			
			boolean hasLighter = false;
			
			if(a.get(cur)==n) hasLighter = true;
			else {
				for(char c:a.keySet()) 
					if(c < cur && a.get(c) < a.get(cur)) hasLighter = true;				
			}
			if(hasLighter) suffix[i]++;
			
			a.put(cur, i);
		}
		System.out.println(Arrays.toString(suffix));

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken());
			sb.append(prefix[x] + suffix[y]).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}


/*
8 2
ABBAABCB
3 6
1 4

8 2
ABBBBBCB
3 6
1 4
*/