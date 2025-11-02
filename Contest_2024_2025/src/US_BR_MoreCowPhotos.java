import java.io.*;
import java.util.*;

public class US_BR_MoreCowPhotos {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] freq = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxH = 0;
            for (int i = 0; i < N; i++) {
                int h = Integer.parseInt(st.nextToken());
                freq[h]++;
                if (h > maxH) maxH = h;
            }

            // prefixPairs[i] = (키 1..i 중) '최소 2번 등장'하는 키의 개수
            int[] prefixPairs = new int[maxH + 1];
            int running = 0;
            for (int h = 1; h <= maxH; h++) {
                if (freq[h] >= 2) running++;
                prefixPairs[h] = running;
            }

            // 피크는 가장 큰 키 maxH로 선택 (해당 키가 최소 1번은 등장)
            // 답 = 1(피크) + 2 * (#pairs below peak)
            int pairsBelowPeak = (maxH >= 2) ? prefixPairs[maxH - 1] : 0;
            int ans = 1 + 2 * pairsBelowPeak;

            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
