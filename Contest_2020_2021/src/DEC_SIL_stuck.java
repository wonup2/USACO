import java.util.*;

public class DEC_SIL_stuck {
     static Scanner in;
     static ArrayList<Integer> E, N;
     static int x[], y[], n, cnt[];
     static boolean isStuck[];

	public static void main(String[] args) {
            in = new Scanner(System.in);
            init();
            solve();
            in.close();
	}
	
	static void init() {
		E = new ArrayList<>();
        N = new ArrayList<>();
        n = in.nextInt();
        x = new int[n];
        y = new int[n];
        for (int j = 0; j < n; j++) {
            if (in.next().charAt(0) == 'E') E.add(j);
            else N.add(j);
        
            x[j] = in.nextInt();
        	y[j] = in.nextInt();
        }
        E.sort(Comparator.comparingInt(j -> y[j]));
        N.sort(Comparator.comparingInt(j -> x[j]));
        isStuck = new boolean[n];
        cnt = new int[n];        
	}
	
	static void solve() {
		
		for (int e : E) {
            for (int n : N) {
                if (!isStuck[e] && !isStuck[n] && x[n] > x[e] && y[e] > y[n]) {
                   if (x[n] - x[e] > y[e] - y[n]) {
                	   isStuck[e] = true;
                       cnt[n] += 1 + cnt[e];
                   } 
                   else if (y[e] - y[n] > x[n] - x[e]) {
                       	isStuck[n] = true;
                       	cnt[e] += 1 + cnt[n];
                   }
                }
            }
		}
       
		for (int j = 0; j < n; j++) System.out.println(cnt[j]);
	}
}