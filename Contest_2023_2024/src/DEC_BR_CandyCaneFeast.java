import java.util.*;
import java.io.*;

public class DEC_BR_CandyCaneFeast {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // number of cows
        int M = sc.nextInt(); // number of candy canes

        long[] cows = new long[N];
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextLong(); // initial heights
        }

        long[] canes = new long[M];
        for (int i = 0; i < M; i++) {
            canes[i] = sc.nextLong(); // candy cane heights
        }

        // Process each candy cane
        for (int i = 0; i < M; i++) {
            long candyHeight = canes[i];
            long base = 0; // current eaten height from bottom

            // Each cow tries to eat
            for (int j = 0; j < N; j++) {
                if (base >= candyHeight) {
                    break; // candy cane fully eaten
                }

                // Cow can eat up to her height
                long eatUpTo = Math.min(cows[j], candyHeight);

                if (eatUpTo > base) {
                    long eaten = eatUpTo - base;
                    cows[j] += eaten; // cow grows after this candy
                    base += eaten;    // move base upward
                }
                // else: cow eats nothing
            }
        }

        // Output final heights
        for (int i = 0; i < N; i++) {
            System.out.println(cows[i]);
        }

        sc.close();
    }
}
