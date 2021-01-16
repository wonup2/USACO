
import java.util.*;
import java.io.*;

public class JAN_SIL_angry {
	static BufferedReader br;
	static PrintWriter pw;
	static int N;
	static int K;
	static int[] x;
	public static void main(String[] args) throws IOException{
		try{
			br = new BufferedReader(new FileReader("angry.in"));
			pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
			
			init();
			solve();		
		}
		catch(Exception e){
			e.printStackTrace();
		}
      
		br.close();
		pw.close();

	}
	static void init() throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		x = new int[N];
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(x);
	}
	static void solve() {
		int low = 0;
		int high = 500000000;
		int mid = 0;
		int ans = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			if(check(mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
			
		}
		pw.println(ans);
	}
	static boolean check(int m) {
		int start = x[0];
		int cow = 1;
		
		for(int i = 0; i < N; i++) {
			if(x[i]-start > m*2) {
				cow++;
				start = x[i];
			}			
		}
		return(cow<=K);
	}
}
