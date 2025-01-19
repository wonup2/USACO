import java.util.Scanner;

public class test {
	static int a[][], g[], n;
	static boolean s[];
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);		
		
		n = in.nextInt();
		
		a = new int[n][2];
		g = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i][0] = in.nextInt()-1;
			a[i][1] = in.nextInt()-1;
			g[i] = in.nextInt()-1;
		}	
		
		solve();
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<3; i++) {
			s = new boolean[3];
			s[i] = true;
			ans = Math.max(ans, game());			
		}
		
		System.out.println(ans);
	}

	static int game() {
		
		int score = 0;
		
		for(int i=0; i<n; i++) {
			
			boolean temp = s[ a[i][0] ];
			s[ a[i][0] ] = s[ a[i][1] ];
			s[ a[i][1] ] = temp;
			
			if( s[g[i]] ) score++;
		}
		
		return score;
	}
}

