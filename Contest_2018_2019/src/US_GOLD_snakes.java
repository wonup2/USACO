import java.util.*;
import java.io.*;

public class US_GOLD_snakes {
	static int N,K;
	static int A[] = new int[10];
	static int dp[][] =new int[10][10];
	static int INF = Integer.MAX_VALUE; 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		int tot = 0;
		int high = 0;
		for(int i=1;i<=N;i++){
			A[i] = in.nextInt();
			high = Math.max(high, A[i]);  System.out.println(high);
			dp[i][0] = high*i;  System.out.println(Arrays.toString(dp[i]));
			for(int j=1;j<=K;j++){
				dp[i][j] = INF;  System.out.println(Arrays.toString(dp[i]));
				int mx = A[i];
				for(int b=i-1;b>=0;b--)	{
					dp[i][j] = Math.min(dp[i][j], dp[b][j-1] + mx*(i-b));
					mx = Math.max(mx, A[b]);
					System.out.println(mx+" "+Arrays.toString(dp[i]));
				}
			}
			tot += A[i];
		}
		System.out.println(dp[N][K] +" "+ tot);
	}

}

