import java.util.Arrays;

public class pair {

	static int n, p[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		n=4;
		p = new int[n+1];
		solve();
	}

	static void solve() {
		int i=0;
		for(i = 0; i<=n; i++) {
			if(p[i]==0) break;
		}
		
		if(i>n) {
			System.out.println(Arrays.toString(p));
			return;
		}
		
		for(int j = i+1; j<=n; j++) {
			if(p[j]==0) {
				p[i]=j;
				p[j]=i;
				solve();
				p[i]=p[j]=0;
			}
		}
	}
}
