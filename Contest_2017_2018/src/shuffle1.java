import java.util.*;
import java.io.*;


public class shuffle1 {

    static BufferedReader in;
    static PrintWriter out;
    //static String file = "shuffle";
    static String file = "shuffle";
    
    static int N, idList[], r1[], r2[], r3[], shuffle[];
    
    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new FileReader(file+".in"));
        out = new PrintWriter(new File(file +".out"));
                
        init();
        solve();
        
        in.close();
        out.close();        
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());

        r1 = new int[N];
        r2 = new int[N];
        r3 = new int[N];
        idList = new int[N];
        shuffle = new int[N];
        
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            shuffle[Integer.parseInt(st.nextToken()) - 1] = i;
            //shuffle[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
            idList[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void solve() {
        for(int i = 0; i < N; i++) {
            r1[shuffle[i]] = i;
        }

        for(int i = 0; i < N; i++) {
            r2[shuffle[i]] = r1[i];
        }

        for(int i = 0; i < N; i++) {
            r3[shuffle[i]] = r2[i];
        }        
        
        for(int i = 0; i < N; i++) {
            out.println(idList[r3[i]]);
        }
    }    
}