import java.io.*;
import java.util.*;
 
public class US_BR_acow2 {
	static BufferedReader in;
	static StringTokenizer st;
	static int k, n;
	static char ans[][];
	static Map<String, Integer> m;
	
    public static void main(String[] args) throws IOException {
    	
    	in = new BufferedReader(new InputStreamReader(System.in));
        init();
        while(k-->0)solve();
        
        StringBuilder out = new StringBuilder();
        for (int a = 0; a < n; a++) 
            out.append(ans[a]).append('\n');
                
        System.out.print(out);
    }
    
    static void init() throws IOException {
    	   	
    	st = new StringTokenizer(in.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = new HashMap<String, Integer>();
        
        st = new StringTokenizer(in.readLine());        
        for (int i = 0; i < n; i++) 
            m.put(st.nextToken(), i);
        
        ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '?');
            ans[i][i] = 'B';
        }
    }
    
    static void solve() throws IOException {    	
        	
        st = new StringTokenizer(in.readLine());
        String[] name = new String[n];
            
        for (int j = 0; j < n; j++) 
            name[j] = st.nextToken();
                        
        for (int x = 0; x < n; x++) {
            boolean ckeck = true;
                
            for (int y = x; y < n-1; y++) {
                if (name[y].compareTo(name[y+1]) > 0) ckeck = false;

                int a = m.get(name[x]);
                int b = m.get(name[y+1]);
                    
                if (!ckeck && ans[a][b]=='?') {
                       
                    ans[a][b] = '0';
                    ans[b][a] = '1';
                }
            }            
        }        
    }
}

/*
더 작은놈이 더 뒤에 나와?
그럼 그 놈이 이겨
비교하는 애들의 원래 순서를 가져와서 그 열과 칸에 써
*/
