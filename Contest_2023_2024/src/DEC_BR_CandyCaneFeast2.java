import java.io.*;
import java.util.*;

public class DEC_BR_CandyCaneFeast2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] cows = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long candy = Long.parseLong(st.nextToken());
            long base = 0; // ?? ???? ?? ?? ??

            for (int j = 0; j < N; j++) {
                if (base >= candy) break; // ?? ? ??

                if (cows[j] > base) {
                    long eat = Math.min(cows[j], candy) - base;
                    cows[j] += eat;   // ??
                    base += eat;      // base ??
                }
                // cows[j] <= base ? ??? ???? ? ?? ? ?? ???
            }
        }

        StringBuilder sb = new StringBuilder();
        for (long h : cows) {
            sb.append(h).append('\n');
        }
        System.out.print(sb.toString());
    }
}
