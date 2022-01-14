import java.util.Arrays;

public class pair {

	static int n, p[];
	public static void main(String[] args) {
		n=4;
		p = new int[n+1];
		solve();
	}

	static int solve() {
		int i=0, ans=0;
		for(i = 1; i<=n; i++) {
			if(p[i]==0) break;
		}
		
		if(i>n) {
			if(hasCycle()) return 1;
			else return 0;
		}
		
		for(int j = i+1; j<=n; j++) {
			if(p[j]==0) {
				p[i]=j;
				p[j]=i;
				ans +=solve();
				p[i]=p[j]=0;
			}
		}
		
		return ans;
	}
	
	static boolean hasCycle() {
		return true;
	}
}
