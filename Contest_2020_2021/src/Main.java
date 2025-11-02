import java.io.*;
import java.util.*;

public class Main {
    static class Cow {
        char dir;      // 'E' or 'N'
        long x, y;     // starting coordinates
        int idx;       // input order index
        Cow(char d, long x, long y, int idx) {
            this.dir = d; this.x = x; this.y = y; this.idx = idx;
        }
    }

    // A crossing situation between one East cow and one North cow
    static class Crossing {
        int blocker;         // cow that arrives first
        int blockee;         // cow that might be stopped
        long blockeeDist;    // how far blockee travels before being stopped
        long blockerDist;    // how far blocker travels to reach the crossing
        long earlier;        // time blocker arrives at crossing

        Crossing(int blocker, int blockee, long blockerDist, long blockeeDist) {
            this.blocker = blocker;
            this.blockee = blockee;
            this.blockerDist = blockerDist;
            this.blockeeDist = blockeeDist;
            this.earlier = blockerDist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = Integer.parseInt(br.readLine().trim());
        Cow[] cows = new Cow[N];
        List<Integer> eastCows = new ArrayList<>();
        List<Integer> northCows = new ArrayList<>();

        // 1. Read cows
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            cows[i] = new Cow(d, x, y, i);
            if (d == 'E') eastCows.add(i); else northCows.add(i);
        }

        // 2. Build list of possible crossings
        List<Crossing> crossings = new ArrayList<>();
        for (int ei : eastCows) {
            Cow e = cows[ei];
            for (int ni : northCows) {
                Cow n = cows[ni];

                long dx = n.x - e.x; // east cow travel to crossing
                long dy = e.y - n.y; // north cow travel to crossing

                if (dx <= 0 || dy <= 0) continue; // no crossing
                if (dx == dy) continue;           // same-time arrival → both continue

                if (dx < dy) {
                    // East arrives first, so it may block North
                    crossings.add(new Crossing(ei, ni, dx, dy));
                } else {
                    // North arrives first, so it may block East
                    crossings.add(new Crossing(ni, ei, dy, dx));
                }
            }
        }

        // 3. Sort by earlier arrival
        crossings.sort(Comparator.comparingLong(c -> c.earlier));

        // 4. Process crossings
        final long INF = Long.MAX_VALUE / 4;
        long[] stopDist = new long[N];
        Arrays.fill(stopDist, INF); // initially infinite

        for (Crossing c : crossings) {
            // if blockee already stopped earlier, skip
            if (stopDist[c.blockee] <= c.blockeeDist) continue;

            // blocker must still be moving when it arrives
            if (stopDist[c.blocker] > c.blockerDist) {
                stopDist[c.blockee] = c.blockeeDist; // blockee stops here
            }
        }

        // 5. Print results in input order
        for (int i = 0; i < N; i++) {
            if (stopDist[i] >= INF) out.println("Infinity");
            else out.println(stopDist[i]);
        }
        out.flush();
    }
}
