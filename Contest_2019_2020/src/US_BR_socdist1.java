import java.util.*;
import java.io.*;

public class US_BR_socdist1{
	static Scanner in;
	static PrintWriter out;
	static int n, high;
	static List<Integer> a;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("socdist1.in"));
		out = new PrintWriter(new File("socdist1.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	public static void init() {
		n=in.nextInt();
		a=new ArrayList<Integer>();
		String s = in.next();
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='1') a.add(i);
		}		
		
		System.out.println(a);

	}
		
	static public void solve() {
		
		if(a.size()==0) { out.println(n-1); return; }
		
		int low=1;
		int high = n-1;
		
		//가장 넓은 간격이 원래 1이 있던 간격보다 높을수는 없지.
		for(int i=1; i<a.size(); i++) {
			high = Math.min(high, a.get(i)-a.get(i-1));
		}
		System.out.println(high);
		int ans = -1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(work(mid)) {
				ans=mid;
				low=mid+1;
			}
			else high=mid-1;
		}		
		out.println(ans);
	}
	
	static boolean work(int d) {
				
		int cow=a.get(0)/d + (n-1-a.get(a.size()-1))/d;  //양끝에 0이면 거기에 놓는것을 우선으로 체크
		
		for(int i=0; i<a.size()-1; i++) {
			int t = (a.get(i+1)-a.get(i))/d - 1;
			cow+= t>0? t:0;
		}
		return cow>=2;
		
	}
	
}