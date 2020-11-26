import java.io.*;
import java.util.*;
public class convention {
	static BufferedReader f;
	static PrintWriter out;
	static int N;
	static int M;
	static int C;
	static int[] a;
	public static void main(String[] args) throws IOException {
		f = new BufferedReader(new FileReader("convention.in"));
		out = new PrintWriter(new FileWriter("convention.out"));
		init();
		solve();
		
		out.close();
		f.close();
	}
	
	static void init() throws IOException{
		StringTokenizer t = new StringTokenizer(f.readLine());
		N = Integer.parseInt(t.nextToken());
		M = Integer.parseInt(t.nextToken());
		C = Integer.parseInt(t.nextToken());
		a = new int[N];
		t = new StringTokenizer(f.readLine());
		for(int i=0; i<N; i++){
			a[i] = Integer.parseInt(t.nextToken());
		}
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
	}
	
	static void solve(){
		int low = 0;
		int high = 14;
		int mid = 0;
		int ans = 0;
		
		
		while(low<=high){
			mid = (low+high)/2;
			if(check(mid)){
				ans = mid;
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean check(int m){
		//System.out.print(N);

		int start = a[0];
		int cow = 0;
		int bus = 1;
		for(int i=0; i<N; i++){
			int wait = a[i]-start;
			cow++;
			System.out.println(m+" "+start+" "+wait+" "+cow + " "+bus);

			if(wait>m || cow>C){
				bus++;
				start = a[i];
				cow=1;
			}
		}
		return bus<=m;
	}
}
