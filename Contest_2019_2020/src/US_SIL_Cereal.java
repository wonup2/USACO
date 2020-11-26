import java.io.*;
import java.util.Arrays;

public class US_SIL_Cereal {
	
	static final String probName="cereal";
	static BufferedReader br;
	static PrintWriter pw;
	
	static int N,M;
	
	static void solve() throws IOException {
		N=readInt();
		M=readInt();
		
		int[] f=new int[N];
		int[] s=new int[N];
		
		for(int i=0;i<N;i++) {
			f[i]=readInt();
			s[i]=readInt();
		}
		
		int[] occupied=new int[M+1];
		int[] ans=new int[N];
		
		int cnt=0;
		for(int i=N-1;i>=0;i--) {
			int cow=i;
			int cereal=f[i];
			while(true) {
				if(occupied[cereal]==0) {
					occupied[cereal]=cow;
					cnt++;
					break;
				}
				else if(occupied[cereal]<cow)
					break;
				else {
					int prevCow=occupied[cereal];
					occupied[cereal]=cow;
					
					if(cereal==s[prevCow])
						break;
					
					cereal=s[prevCow];
					cow=prevCow;
				}
			}
			ans[i]=cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i:ans)
			sb.append(i).append("\n");
		pw.print(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		st=new StreamTokenizer(br=new BufferedReader(new FileReader(probName+".in")));
		
		pw=new PrintWriter(new BufferedWriter(new FileWriter(probName+".out")));
		
		solve();
		
		br.close();
		
		pw.close();
	}
	
	static StreamTokenizer st;
	static int readInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
}
