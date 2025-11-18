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

            // Count frequencies & track maximum height
            for (int i = 0; i < N; i++) {
                int h = Integer.parseInt(st.nextToken());
                freq[h]++;
                if (h > maxH) maxH = h;
            }

            // Count how many distinct heights < maxH appear at least twice
            int pairs = 0;
            for (int h = 1; h < maxH; h++) {
                if (freq[h] >= 2) pairs++;
            }

            int answer = 1 + 2 * pairs; // peak(1) + symmetric pairs
            out.append(answer).append('\n');
        }

        System.out.print(out.toString());
    }
}
