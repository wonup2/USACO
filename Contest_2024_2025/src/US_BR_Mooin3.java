import java.util.*;
import java.io.*;

public class US_BR_Mooin3 {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;

	static int n, q, l, r;
	static String s;
	static TreeSet<Integer>[] pos;
	
	public static void main(String[] args) throws IOException {

		//in = new Scanner(System.in);
		in = new BufferedReader(new InputStreamReader(System.in));
		
		init();
		//solve();
		in.close();
	}

	static void init()throws IOException {
		st = new StringTokenizer(in.readLine());
	
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		s = in.readLine();
		
		pos = new TreeSet[26];
		for(int i=0; i<26; i++) pos[i] = new TreeSet<Integer>();
		for(int i=0; i<n; i++) {
			char c = s.charAt(i);
			int idx = c-'a';
			pos[idx].add(i+1);
		}		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++)	sb.append(solve()).append("\n");		
		
		System.out.print(sb.toString());
	}
	
	static long solve() throws IOException {
		//i, j, k
	
		st = new StringTokenizer(in.readLine());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		long ret = -1l;
		
		for(int c = 0; c<26; c++) {
			
			if(pos[c].size()==0) continue;
			
			//i: leftmost not c
			
			//k: rightmost c 
						
			//j: middle c
			//j1, j2
			
		}
		
		
		return ret;
	}
}

/*
12 1
abcabbacabac
4 8

*/
