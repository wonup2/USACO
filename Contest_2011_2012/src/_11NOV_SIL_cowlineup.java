import java.util.*;

public class _11NOV_SIL_cowlineup {

	static Scanner in;
	static int n, ans=Integer.MAX_VALUE, l, r;
	static HashMap<Integer, Integer> id;
	static cows a[];
	static class cows implements Comparable<cows>{
		int x, id;
		cows(int a, int b){
			x = a; id = b; 
		}
		@Override
		public int compareTo(cows o) {			
			return this.x-o.x;
		}
		public String toString() {
			return x+" "+id;
		}
	}
	static void init() {
		n = in.nextInt();
		a = new cows[n];
		id = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[i] = new cows(x, y);
			id.put(y, 0);
		}
		Arrays.sort(a);
		System.out.println(id);
		System.out.println(Arrays.toString(a));
		
		if(id.size()<=1) System.out.println(0);
		else solve();
	}
	
	static void solve() {
		l=0; r=0;
		int cnt = 0;
		int totalBreed = id.size();
		int leftCow = a[0].id;
		int rightCow = a[0].id;
		
		for(int r=0; r<n; r++) {
			rightCow = a[r].id;
			int num = id.getOrDefault(rightCow, 0);
			if (num==0) cnt++;
			id.put(rightCow, num+1);

			System.out.println(l+" " + r + " "+ id);
			while(cnt==totalBreed && l<=r) {
				
				ans = Math.min(ans, a[r].x - a[l].x);
				
				leftCow = a[l].id;
				num = id.get(leftCow);
				if(num==1) {
					id.remove((Integer)leftCow);
					cnt--;
				}
				else id.put(leftCow, id.get(leftCow)-1);
				
				l++;
			}			
		}
		
		System.out.println(ans);
	}
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
	}

}
