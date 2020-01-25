
import java.util.*;
import java.io.*;
public class JAN_GOLD_sleepy {

	static int MAXN=5;
	static int[] T = new int[MAXN];
	static int[] p = new int[MAXN];

	static void inc(int i){
		for(i++;i<MAXN;i+=(i&-i)){
			T[i]++;
		}
	}
	 
	static int getSum(int i){
		int c = 0;
		for(i++;i>0;i-=(i&-i)) {
			c += T[i];
		}
		return c;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter out = new PrintWriter(new FileWriter("sleepy.out"));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++){
			p[i] = Integer.parseInt(st.nextToken());
			p[i]--;
		}
		
		
		int j = N-1;
		while(j > 0 && p[j-1] < p[j])
			j--;

		out.println("J : "+j);
		
		for(int i=j;i<N;i++) {
			inc(p[i]);			
		}
		
		for(int i=0;i<j;i++) {
			out.print((j - 1 - i) + getSum(p[i]));				
			if(i < j - 1) out.print(" ");
			inc(p[i]);
		}
		
		out.println();
		in.close();
		out.close();
	}
}
