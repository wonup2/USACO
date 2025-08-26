import java.util.*;
import java.io.*;

public class DEC_BR_measurement1 {

    static Scanner in;
    static PrintWriter out;
    static int n;
    // day -> (cowIndex -> delta)
    static TreeMap<Integer, HashMap<Integer, Integer>> logByDay;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        in.close();
        out.close();
    }

    static void init() throws IOException {
        // USACO-style file IO
        in  = new Scanner(new FileReader("measurement.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        n = in.nextInt();
        logByDay = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int day = in.nextInt();
            String name = in.next();
            int delta = in.nextInt(); // "+3"/"-2" parsed fine by nextInt()

            int idx = idxOf(name); // 0=Bessie,1=Elsie,2=Mildred
            HashMap<Integer, Integer> h = new HashMap<>();
            h.put(idx, delta);

            // At most one measurement per day ? safe to put
            logByDay.put(day, h);
        }
    }

    static void solve() {
        int[] milk = {7, 7, 7};

        // previous leaders: start with all three displayed
        boolean[] prev = new boolean[3];
        Arrays.fill(prev, true);

        boolean[] cur = new boolean[3];
        int changes = 0;

        for (HashMap<Integer, Integer> h : logByDay.values()) {
            // Apply today's only update
            int idx = h.keySet().iterator().next(); // the unique key for the day
            int delta = h.get(idx);
            milk[idx] += delta;

            // Recompute leaders
            int max = Math.max(milk[0], Math.max(milk[1], milk[2]));
            for (int i = 0; i < 3; i++) cur[i] = (milk[i] == max);

            // Compare boards
            if (cur[0] != prev[0] || cur[1] != prev[1] || cur[2] != prev[2]) {
                changes++;
            }

            // prev <- cur (copy values)
            System.arraycopy(cur, 0, prev, 0, 3);
        }

        out.println(changes);
        out.flush();
    }

    static int idxOf(String s) {
        if (s.equals("Bessie")) return 0;
        if (s.equals("Elsie"))  return 1;
        return 2; // Mildred
    }
}
