import java.io.*;
import java.util.*;
 
public class FEVB_SIL_comfortable{
	
	static BufferedReader in;
	
    static final boolean[][] c = new boolean[3000][3000];
    static final int[][] a = new int[3000][3000];
    static int cnt = 0;
    static int[] dx= {-1, 1, 0, 0}, dy= {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        in.close();
    }
    
    static void init() throws NumberFormatException, IOException {
    	
    	StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());        
        for (int j = 0; j < n; j++) {
        	
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tokenizer.nextToken()) + 1000;
            int y = Integer.parseInt(tokenizer.nextToken()) + 1000;
            cnt--;
            dfs(x, y);
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    
    static void dfs(int x, int y) {
    	
        if (c[x][y]) return;
            
        c[x][y] = true;
        cnt++;
        
        if (a[x][y] == 3) {
        	for (int i=0; i<4; i++) {
        		int nx = x+dx[i];
                int ny = y+dy[i];
                dfs(nx, ny);              
        	}            
        }
            
        for (int i=0; i<4; i++) {
        	int nx = x+dx[i];
            int ny = y+dy[i];
          
            a[nx][ny]++;
            if (c[nx][ny] && a[nx][ny] == 3) {
            	for (int j=0; j<4; j++) { 
                   int w = nx+dx[j];
                   int z = ny+dy[j];
                   dfs(w, z);
                }
            }            
        }
    }
}
    
