import java.io.*;
import java.util.*;

public class US_Silver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[][] teams = new int[N][C]; // 각 팀의 소의 종류를 저장할 배열
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'H') teams[i][j] = 1; // Holstein 은 1로 저장
                else teams[i][j] = 0; // Guernsey 는 0으로 저장
            }
        }

        int[] maxDiff = new int[N]; // 각 팀의 최대 차이를 저장할 배열
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int diff = 0;
                for (int k = 0; k < C; k++) {
                    if (teams[i][k] != teams[j][k]) diff++; // 두 팀의 k번째 소가 다르면 차이 증가
                }
                maxDiff[i] = Math.max(maxDiff[i], diff); // i번째 팀과 j번째 팀의 차이 중 큰 값을 저장
                maxDiff[j] = Math.max(maxDiff[j], diff);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(maxDiff[i]); // 각 팀의 최대 차이 출력
        }
        
    }
}
