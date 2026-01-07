import java.io.*;
import java.util.*;

public class US_BR_Mooin3 {
	
	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int n, q, l, r;
	static long ans;
	static String s; 
	static TreeSet<Integer> a[];
	
	static void init() throws IOException{
		st = new StringTokenizer(in.readLine());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());		
	}
	
	static void solve() {
		
		Integer i=n+1, j=0, k=0;
		
		for(int x = 0; x<26; x++) {
			
			//i		
			i=n+1;
			for(int y=0; y<26; y++) {
				if(a[y].size()==0) continue;				
				if(x==y) continue;
				
				Integer t = a[y].ceiling(l);
				if(t==null) continue;		
				i = Math.min(i, t);
			}
			
		
			if(a[x].size()==0) continue;			

			//k
			k = a[x].floor(r);
			if(k==null) continue;
			if(k<i || k<l) continue;
			
			//j			
			int mid = (i+k)/2;
			j = a[x].floor(mid);			
			
			if(j!=null && i<j && j<k) {
				long val = (long) (j - i) * (long) (k - j);
				ans = Math.max(ans, val);
			}
			
			j = a[x].ceiling(mid);			

			if(j!=null && i<j && j<k) {
				long val = (long) (j - i) * (long) (k - j);
				ans = Math.max(ans, val);				
			}			
		}						
		sb.append(ans).append("\n");
	}
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		s = in.readLine();
		
		a = new TreeSet[26];
		for(int i=0; i<26; i++) a[i] = new TreeSet<Integer>();
		
		for(int i=0; i<n; i++) {
			int idx = s.charAt(i)-'a';			
			a[idx].add(i+1);
		}		
		
		while(q -->0) {
			ans = -1l;
			init();
			solve();
		}
		
		System.out.print(sb.toString());
        in.close();
	}
}