import java.util.*;
import java.io.*;

public class US_SIL_leftout {
	static int N;
	static int grid[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("leftout.in"));
		PrintWriter out = new PrintWriter(new File("leftout.out"));
		String s;
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		for (int i=0; i<N; i++) {
		    char temp[] = in.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				grid[i][j] = temp[j]=='L'?1:0;
			}
		}
		System.out.println(Arrays.deepToString(grid));

		// Flip columns and rows so top row and left column all zero
		for (int i=1; i<N; i++) {
		  grid[i][0] = grid[i][0] ^ grid[0][0];
		  for (int j=1; j<N; j++) grid[i][j] = grid[i][j] ^ grid[0][j] ^ grid[i][0];
		}
		 
		System.out.println(Arrays.deepToString(grid));

		if (num (1,1,N-1,N-1,0) == 0) out.println("1 1");
		if (num (1,1,N-1,N-1,1) == N-1) {
			for (int j=1; j<N; j++) if (num(1,j,N-1,j,1)==N-1) out.println("1 " + (j+1));
			for (int i=1; i<N; i++) if (num(i,1,i,N-1,1)==N-1) out.println(i+1 + " 1"); 
		    out.println("-1\n");
		}
		  
		if (num(1,1,N-1,N-1,1)!=1) out.println("-1");
		for (int i=1; i<N; i++)
		  for (int j=1; j<N; j++)
		    if (grid[i][j]==1) out.println(i+1 + " " + (j+1));
		
		in.close();
		out.close();
	}
	
	static int num(int i1, int j1, int i2, int j2, int b) {
		int total = 0;
		for (int i=i1; i<=i2; i++) {
			for (int j=j1; j<=j2; j++) {
				if (grid[i][j] == b) total++;
			}
		}
		System.out.println(total);
		return total;
	}
}