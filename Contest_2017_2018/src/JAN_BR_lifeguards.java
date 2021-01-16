import java.util.*;
import java.io.*;

public class JAN_BR_lifeguards {
    static Scanner in;
    static PrintWriter out;
    static int N, s[], e[], a[];

    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("lifeguards.in"));
        out = new PrintWriter(new FileWriter("lifeguards.out"));
        init();
        solve();
        in.close();
        out.close();

    }

    static void init() throws IOException {
        N = in.nextInt();
        s = new int[N];
        e = new int[N];
        for(int i=0; i<N; i++) {
            s[i] = in.nextInt();
            e[i] = in.nextInt();
        }

        a = new int[1001];
    }

    static void solve() {
        int total = 0;
        for(int i=0; i<N; i++) {
            for(int j=s[i]; j<e[i]; j++) {
                a[j]++;
                if(a[j] == 1) total++;
            }
        }
        
        int noWatchTime = 10000;
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=s[i]; j<e[i]; j++) {
                if(a[j] == 1) count++;
            }
            noWatchTime = Math.min(noWatchTime, count);
            count = 0;
        }
        
        total -= noWatchTime;
        out.println(total);
    }

}