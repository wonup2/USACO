import java.io.*;
import java.util.*;

public class US_SIL_Social{
	
	static final String probName="socdist1";
	static BufferedReader in;
	static PrintWriter pw;
	static final long MAX=1000000000000000000l;
	
	static int N,M;
	static Pair[] a;
			
	static void init() throws IOException {
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a=new Pair[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			a[i]=new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
			
		Arrays.sort(a);
	}
		
	static void solve()  {	

		long low=1;
		long high=MAX;
		long ans=-1;
		
		while(low<=high) {
			long mid=(low+high)/2;
			
			if(works(mid)) {
				ans=mid;
				low=mid+1;
			}
			else
				high=mid-1;
		}
		
		pw.println(ans);
	}
	
	
	
	
	static boolean works(long d) {
		
		long cur = -MAX;		
		int cnt = 0;
		
		for(Pair p:a) {
			
			while(Math.max(cur+d, p.f)<=p.s){
				cur=Math.max(cur+d, p.f);
				cnt++;
				if(cnt>=N) return true;
			}
			
		}	
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
	
		in = new BufferedReader(new FileReader("socdist.in"));
		pw=new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		
		init();
		solve();
		
		in.close();		
		pw.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int f,s;		
		Pair(int first,int second){
			f=first;
			s=second;
		}		
		public int compareTo(Pair that) {	
			
			if(this.f==that.f)
				return this.s-that.s;
			
			return this.f-that.f;		
		}
		@Override
		public String toString() {
			return f+" "+s;
		}
	}
}
