import java.io.*;
import java.util.*;
public class numtri {
	static int[][] tri;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		tri=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				tri[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		out.println(solve());
		out.close();
		br.close();
	}
	public static int solve() {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				tri[i-1][j]=Math.max(tri[i][j]+tri[i-1][j], tri[i][j+1]+tri[i-1][j]);
			}
		}
		return tri[0][0];
	}
}