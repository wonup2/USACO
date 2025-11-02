import java.io.*;
import java.util.*;

public class Bakery {
    static int N, TC, TM;
    static int[][] orders;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            TC = Integer.parseInt(st.nextToken());
            TM = Integer.parseInt(st.nextToken());
            orders = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                orders[i][0] = Integer.parseInt(st.nextToken());
                orders[i][1] = Integer.parseInt(st.nextToken());
                orders[i][2] = Integer.parseInt(st.nextToken());
            }

            // DP 배열 초기화
            dp = new long[N+1][2001];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], Long.MAX_VALUE / 2); // overflow 방지
                dp[i][0] = 0;
            }

            // DP
            for (int i = 1; i <= N; i++) {
                int a = orders[i-1][0];
                int b = orders[i-1][1];
                int c = orders[i-1][2];

                for (int j = 1; j <= 2000; j++) {
                    if (j-a >= 0) { // a개의 쿠키를 만드는 시간이 j 이상일 때
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-a] + (long)a*TC);
                    }
                    if (j-b >= 0) { // b개의 머핀을 만드는 시간이 j 이상일 때
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-b] + (long)b*TM);
                    }
                }

                for (int j = 1; j <= 2000; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]); // 이전 시간까지 만들 수 있는 가장 적은 시간으로 갱신
                }

                for (int j = 1; j <= 2000; j++) {
                    if (dp[i][j] > c) { // 만들 수 없는 경우
                        dp[i][j] = Long.MAX_VALUE / 2; // overflow 방지
                    }
                }
            }

            // 정답 출력
            long ans = Long.MAX_VALUE / 2;
            for (int j = 1; j <= 2000; j++) {
                ans = Math.min(ans, dp[N][j]);
            }
            System.out.println(ans);
        }
    }
}
