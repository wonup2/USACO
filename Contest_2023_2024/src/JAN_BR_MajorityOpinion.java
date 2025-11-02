import java.util.*;
import java.io.*;

public class JAN_BR_MajorityOpinion {

	static BufferedReader in;
	static StringTokenizer st;
	static int T, N, a[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(in.readLine());
		while(T-->0) {
			init();
			solve();
		}		
		in.close();
	}

	static void init() throws IOException {
		
		N = Integer.parseInt(in.readLine());		
		st = new StringTokenizer(in.readLine());
		a = new int[N];
		for(int i=0; i<N; i++) a[i] = Integer.parseInt(st.nextToken());
	}
	
	static void solve() throws IOException {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		String ans = "";
		
		if(N==2 && a[0]==a[1]) set.add(a[0]);
		
		for(int i=0; i<N-2; i++) {
			if(a[i] == a[i+1] || a[i] == a[i+2]) set.add(a[i]);
			else if(a[i+1]==a[i+2]) set.add(a[i+1]);
		}
		
		if(set.size()==0) ans="-1";
		else for(int n:set) ans+= n+" ";
		
		System.out.println(ans.trim());
	}
}


/*
5
5
1 2 2 2 3
6
1 2 3 1 2 3
6
1 1 1 2 2 2
3
3 2 3
2
2 1


*/
