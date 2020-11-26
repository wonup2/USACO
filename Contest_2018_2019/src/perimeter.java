import java.io.*;
import java.util.*;
public class perimeter {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N, max, count, per, ansper;
	static String[][] a;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int nx, ny;

	public static void main(String[] args) {
		
		try {
			in = new BufferedReader(new FileReader("perimeter.in"));
			out = new PrintWriter(new File("perimeter.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		//System.out.println(N);
		a = new String[N][N];
		max = 0;
		count = 0;
		
		for(int i =0; i < N; i++) {
			String temp = in.readLine();
			for(int j =0; j < N; j++) {
				a[i][j] = "" + temp.charAt(j);
			}
		}
	}
	
	private static void solve() {
		for(int i =0; i < N ; i++) {
			for(int j =0; j < N; j++) {
				if(a[i][j].equals("#")){
					dfs(i, j);
					if(count > max) {
						max = count;
						ansper = per;
					}else if(count == max) {
						ansper = Math.min(ansper, per);
					}
					count= 0;
					per =0;
				}
			}
		}
		out.println(max + " " + ansper);
		
	}
	
	private static void dfs(int x, int y) {
		if(!isValid(x,y)) {
    	   per++; 
    	   return;
       }       
      //stop point
       
       
       if( a[x][y].equals(".") ) {
    	   per++; return;
       }
       if( a[x][y].equals("*") ) return;
         
      a[x][y]="*"; 
      count++;
      dfs(x, y+1);
      dfs(x, y-1);
      dfs(x+1, y);
      dfs(x-1, y);
         
         return;
         
         
    }
    private static boolean isValid(int x, int y){
       return x>=0 && x<N && y>=0 && y<N;
     
    } 
}
