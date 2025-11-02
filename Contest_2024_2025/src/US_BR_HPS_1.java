import java.io.*;
import java.util.*;

public class US_BR_HPS_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 승패표 (행 = Bessie, 열 = Elsie)
        char[][] a = new char[N + 1][N + 1];

        // N개의 줄 입력받기
        for (int i = 1; i <= N; i++) {
            String line = br.readLine().trim();
            for (int j = 1; j <= i; j++) {
                char c = line.charAt(j - 1);
                a[i][j] = c;
                if (i != j) {
                    // 대칭 관계 채워 넣기
                    if (c == 'W') a[j][i] = 'L';
                    else if (c == 'L') a[j][i] = 'W';
                    else a[j][i] = 'D';
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 각 게임별 질의 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            // 두 심볼을 모두 이길 수 있는 심볼 찾기
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (a[i][s1] == 'W' && a[i][s2] == 'W') count++;
            }

            // N^2 - (N - count)^2 = 2*N*count - count^2
            long ans = 1L * N * N - 1L * (N - count) * (N - count);
            sb.append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
