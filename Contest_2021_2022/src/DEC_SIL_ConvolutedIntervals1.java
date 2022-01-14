import java.util.*;
import java.io.*;
 
public class DEC_SIL_ConvolutedIntervals1 {
	static BufferedReader in;
	static StringTokenizer st;
	static int n, m;
	static long a[], b[], p[];
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(in.readLine());
        init();
        solve();        
    }
    
    static void init() throws IOException {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new long[m + 1];
        b = new long[m + 1];
        for (int j = 1; j <= n; j++) {
            st = new StringTokenizer(in.readLine());
            a[Integer.parseInt(st.nextToken())]++;
            b[Integer.parseInt(st.nextToken())]++;
        }
    }
    
    static void solve() {

        p = new long[(2 * m) + 2];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                p[i + j] += a[i] * a[j];
                p[i + j + 1] -= (b[i] * b[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(p[0]).append('\n');

        for(int i=1; i<=m*2; i++) {
        	p[i] += p[i-1];  //no need
            sb.append(p[i]).append('\n');
        }       
        
        System.out.print(sb.toString());
    }
}