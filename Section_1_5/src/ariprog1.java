/*
ID: wonup21
LANG: JAVA
TASK: ariprog
 */

//Brute Force

import java.io.*;
import java.util.*;

public class ariprog1 {
	static Scanner in;
	static PrintWriter out;
	static int N, M;
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("ariprog.in"));
			out = new PrintWriter(new File("ariprog.out"));
			init();
			out.print(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		N=in.nextInt();
		M=in.nextInt();
	}
	
	static String solve() {
		// max: 250 * 250 * 2 = 125000
		int MM2 = M*M*2;
		boolean[] bis = new boolean[MM2+1];
		for(int p=0; p<=M; p++) 
			for(int q=0; q<=M; q++) {
				System.out.printf("%d^2 + %d^2 = %d + %d = %d\n", p,q,p*p, q*q, p*p+q*q);
				bis[p*p+q*q] = true;
			}
System.out.println(Arrays.toString(bis));	
		ArrayList<int[]> res = new ArrayList<int[]>();
		
		for(int a = 0; a<MM2; a++) {
			if(!bis[a]) continue;
		label:
			for(int b=1; b<=(MM2-a)/(N-1); b++) {
				for(int i=1; i<=N-1; i++) {
					if(!bis[a+b*i]) continue label;
				}
				res.add(new int[] {a,b});
			}
		}
System.out.println(print(res));
		Collections.sort(res,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				else return o1[1]-o2[1];
			}
		});
			
		String result=print(res);	
		return result.length()==0? "NONE\n": result;
	}
	
	
	
	static String print(ArrayList<int[]> res) {
		StringBuilder sb = new StringBuilder();
		for(int[] i:res) 
			sb.append(i[0]).append(" ").append(i[1]).append("\n");
		
		return sb.toString();			
	}
}