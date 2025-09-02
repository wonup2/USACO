import java.util.*;
import java.io.*;

public class US_SIL_where {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;

	static int N,A;
	static char[][] F, temp;
	static ArrayList<PCL> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("where.in")); 
		out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
				
		init();
		//solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine()); 		
		F = new char[N][]; 
		temp = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			F[i] = in.readLine().toCharArray();			
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						if(check(i, j, k, l)) {
							list.add(new PCL(i,j,k,l));
						}
					}
				}
			}
		}
//[0 0 2 0, 0 0 2 1, 0 0 2 2, 0 0 3 0, 0 0 3 2, 0 1 3 1, 0 2 3 3, 0 3 3 3, 1 0 3 1, 1 1 3 1, 1 2 3 3, 1 3 3 3]
		
		for (int i = 0; i < list.size(); i++) {
			if(max(i)) A++;
		}
		
// 0 0 3 2,  0 2 3 3
		
		out.println(A);
		out.close();
	}
	
	public static boolean max(int x){
		for (int i = 0; i < list.size(); i++) {
			if(i==x) continue;
			if(inside(list.get(x), list.get(i))) return false;
		}
		return true;
	}
	
	public static boolean inside(PCL me, PCL other){
		return me.i >= other.i && me.j >= other.j && me.k <= other.k && me.l <= other.l;
	}
		
	//Takes the top-left point and the bottom-right point	
	public static boolean check(int i1, int j1, int i2, int j2)
	{
	
		int co = 0;
		
		int[] color = new int[26];
		
		for (int i=i1; i<=i2; i++)
			for (int j=j1; j<=j2; j++)
				temp[i][j] = F[i][j];
		
		
		
		for (int i=i1; i<=i2; i++)
			for (int j=j1; j<=j2; j++)
				if (temp[i][j] != '-') {
					int c = temp[i][j] - 'A';
					if (color[c] == 0) co++;
					
					color[c]++;
					ff(i,j,temp[i][j]);
				}
		
		if (co != 2) return false;	
		
		boolean one = false, more = false;
		
		for (int i=0; i<26; i++) {
			if (color[i] == 1) one = true;
			if (color[i] > 1) more = true;
		}		

		return one && more;
	}

	public static void ff(int i, int j, char C){
		if(i < 0 || j < 0 || i >= N || j >= N || temp[i][j] != C) return;
		
		temp[i][j] = '-';

		ff(i, j-1, C);
		ff(i, j+1, C);
		ff(i-1, j, C);
		ff(i+1, j, C);
	}
	
	
	
	static class PCL{
		int i, j, k, l;
		PCL(int a, int b, int c, int d){
			i = a; j = b; k = c; l = d;
		}
		public String toString() {
			return i+" "+j+" "+k+" "+l;
		}
	}
}